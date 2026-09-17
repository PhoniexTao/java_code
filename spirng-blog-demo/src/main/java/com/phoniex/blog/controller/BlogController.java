package com.phoniex.blog.controller;

import com.phoniex.blog.pojo.response.BlogInfoResponse;
import com.phoniex.blog.service.BlogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/blog")
@RestController
public class BlogController {
    @Resource(name = "blogServiceImpl")
    private BlogService blogService;

    @RequestMapping("/getlist")
    public List<BlogInfoResponse> getList() {
        log.info("获取博客列表..");
        List<BlogInfoResponse> blogInfos = blogService.getList();
        return blogInfos;
    }
}
