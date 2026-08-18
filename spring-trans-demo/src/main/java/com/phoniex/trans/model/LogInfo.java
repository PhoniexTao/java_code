package com.phoniex.trans.model;

import lombok.Data;

@Data
public class LogInfo {
    private Integer id;
    private String userName;
    private String op;
    private Data createTime;
    private Data updateTime;
}
