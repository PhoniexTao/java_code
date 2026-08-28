package com.phoniex.blog.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

//`id` INT NOT NULL AUTO_INCREMENT,
//    `title` VARCHAR(200) NULL,
//    `content` TEXT NULL,
//    `user_id` INT(11) NULL,
//    `delete_flag` TINYINT(4) NULL DEFAULT 0,
//    `create_time` DATETIME DEFAULT now(),
//    `update_time` DATETIME DEFAULT now() ON UPDATE now(),
@Data
public class BlogInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private LocalDate createTime;
    private LocalDate updateTime;
}
