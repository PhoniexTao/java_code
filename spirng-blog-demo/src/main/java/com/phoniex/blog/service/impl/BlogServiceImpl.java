package com.phoniex.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.phoniex.blog.mapper.BlogInfoMapper;
import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.response.BlogInfoResponse;
import com.phoniex.blog.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public List<BlogInfoResponse> getList() {
        QueryWrapper<BlogInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(BlogInfo::getDeleteFlag,0);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
        List<BlogInfoResponse> blogInfoResponses = blogInfos.stream().map(blogInfo -> {
            BlogInfoResponse response = new BlogInfoResponse();
            BeanUtils.copyProperties(blogInfo, response);
            return response;
        }).collect(Collectors.toList());
        return blogInfoResponses;
    }
}
