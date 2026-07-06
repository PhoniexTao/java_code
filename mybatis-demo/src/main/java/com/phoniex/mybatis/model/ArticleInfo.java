package com.phoniex.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deletFlag;
    private Date createTime;
    private Date updateTime;
}
