package com.phoniex.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.phoniex.blog.common.constant.Constants;
import com.phoniex.blog.common.context.UserContext;
import com.phoniex.blog.common.exception.BlogException;
import com.phoniex.blog.common.util.BeanTranUtils;
import com.phoniex.blog.mapper.BlogInfoMapper;
import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.request.AddBlogRequest;
import com.phoniex.blog.pojo.request.UpdateBlogRequest;
import com.phoniex.blog.pojo.response.BlogInfoResponse;
import com.phoniex.blog.service.BlogService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getList() {
        //使用自定义条件语句
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        //创建该条件逻辑
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,Constants.BLOG_NORMAL);
        //使用该条件逻辑来进行sql操作得到数据
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
        //对数据进行筛选处理
//        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream().map(blogInfo -> {
//            BlogInfoResponse response = new BlogInfoResponse();
//            //使用属性拷贝类工具来进行转换
//            BeanUtils.copyProperties(blogInfo, response);
//            return response;
//        }).collect(Collectors.toList());
        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream()
            .map(blogInfo -> BeanTranUtils.trans(blogInfo))
            .collect(Collectors.toList());
        return blogInfoResponses;
    }

    @Override
    public BlogInfoResponse getBlogDetail(Integer blogId) {
        BlogInfo blogInfo = getBlogInfo(blogId);
        return BeanTranUtils.trans(blogInfo);
    }
    @Override
    public BlogInfo getBlogInfo(Integer blogId){
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag, Constants.BLOG_NORMAL)
            .eq(BlogInfo::getId,blogId);
        BlogInfo blogInfo = blogInfoMapper.selectOne(queryWrapper);
        return blogInfo;
    }

    @Override
    public Boolean addBlog(AddBlogRequest addBlogRequest) {
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(addBlogRequest, blogInfo);
        blogInfo.setUserId(UserContext.getUserId());
        try{
            Integer result = blogInfoMapper.insert(blogInfo);
            if(result == 1){
                return true;
            }
            return false;
        }catch (Exception e){
            log.error("博客插入失败，e:", e);
            throw new BlogException("内部错误,请联系管理员");
        }
    }

    @Override
    public Boolean updateBlog(UpdateBlogRequest updateBlogRequest) {
        checkOwnership(updateBlogRequest.getId());
        BlogInfo blogInfo = BeanTranUtils.trans(updateBlogRequest);
        try {
            int result = blogInfoMapper.updateById(blogInfo);
            return result == Constants.BLOG_DELETE;
        } catch (Exception e) {
            log.error("更新博客失败,e:", e);
            throw new BlogException("内部错误，请联系管理员");
        }
    }

    @Override
    public Boolean delete(Integer blogId) {
        checkOwnership(blogId);
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setId(blogId);
        blogInfo.setDeleteFlag(Constants.BLOG_DELETE);
        try {
            Integer result = blogInfoMapper.updateById(blogInfo);
            return result == 1;
        }catch (Exception e){
            log.error("删除博客失败, e:", e);
            throw new BlogException("内部错误，请联系管理员");
        }
    }

    /**
     * 博客归属校验
     * @param blogId
     */
    private void checkOwnership(Integer blogId){
        BlogInfo blogInfo = getBlogInfo(blogId);
        if(blogInfo == null){
            throw new BlogException("博客不存在");
        }
        if(!blogInfo.getUserId().equals(UserContext.getUserId())){
            throw new BlogException("无权操作该博客");
        }
    }

}
