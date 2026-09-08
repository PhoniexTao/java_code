package com.phoniex.blog.common.util;

import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.dataobject.UserInfo;
import com.phoniex.blog.pojo.request.UpdateBlogRequest;
import com.phoniex.blog.pojo.response.BlogInfoResponse;
import com.phoniex.blog.pojo.response.UserInfoResponse;
import org.springframework.beans.BeanUtils;

public class BeanTranUtils {
    public static BlogInfoResponse trans(BlogInfo blogInfo){
        if (blogInfo == null){
            //TODO 待做事项
            return null;
        }
        BlogInfoResponse response = new BlogInfoResponse();
        BeanUtils.copyProperties(blogInfo,response);
        return response;
    }
    public static UserInfoResponse trans(UserInfo userInfo){
        if(userInfo == null){
            return null;
        }
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        BeanUtils.copyProperties(userInfo, userInfoResponse);
        return userInfoResponse;
    }
    public static BlogInfo trans(UpdateBlogRequest request){
        if(request == null){
            return null;
        }
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(request, blogInfo);
        return blogInfo;
    }
}
