package com.phoniex.blog.pojo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

//DROP TABLE IF EXISTS java_blog_spring.user_info;
//    CREATE TABLE java_blog_spring.user_info(
//    `id` INT NOT NULL AUTO_INCREMENT,
//    `user_name` VARCHAR ( 128 ) NOT NULL,
//    `password` VARCHAR ( 128 ) NOT NULL,
//    `github_url` VARCHAR ( 128 ) NULL,
//    `delete_flag` TINYINT ( 4 ) NULL DEFAULT 0,
//    `create_time` DATETIME DEFAULT now(),
//    `update_time` DATETIME DEFAULT now() ON UPDATE now(),
//    PRIMARY KEY ( id ),
//    UNIQUE INDEX user_name_UNIQUE ( user_name ASC )) ENGINE = INNODB DEFAULT CHARACTER
//    SET = utf8mb4 COMMENT = '用户表';
@Data
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String githubUrl;
    private Integer deleteFlag;
    private LocalDate createTime;
    private LocalDate updateTime;
}
