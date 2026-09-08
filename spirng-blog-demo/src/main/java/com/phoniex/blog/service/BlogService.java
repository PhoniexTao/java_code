package com.phoniex.blog.service;

import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.request.AddBlogRequest;
import com.phoniex.blog.pojo.request.UpdateBlogRequest;
import com.phoniex.blog.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getList();

    BlogInfoResponse getBlogDetail(Integer blogId);

    BlogInfo getBlogInfo(Integer blogId);

    Boolean addBlog(AddBlogRequest addBlogRequest);

    Boolean updateBlog(UpdateBlogRequest updateBlogRequest);

    Boolean delete(Integer blogId);
}
