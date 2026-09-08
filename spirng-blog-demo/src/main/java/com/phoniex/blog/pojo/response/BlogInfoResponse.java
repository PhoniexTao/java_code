package com.phoniex.blog.pojo.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.phoniex.blog.common.util.DateUtils;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlogInfoResponse {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;


//    public String getCreateTime(){
//        return DateUtils.dateFormat(createTime);
//    }
}
