package com.phoniex.blog.service;

import com.phoniex.blog.pojo.dataobject.BlogInfo;
import com.phoniex.blog.pojo.response.BlogInfoResponse;

import java.util.List;

public interface BlogService {
    List<BlogInfoResponse> getList();
}
