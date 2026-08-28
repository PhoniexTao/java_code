package com.phoniex.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.phoniex.blog.pojo.dataobject.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {
}
