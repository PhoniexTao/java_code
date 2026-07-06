package com.phoniex.mybatis.mapper;

import com.phoniex.mybatis.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleInfoMapper {
    ArticleInfo selectArticleInfoById(Integer id);

}
