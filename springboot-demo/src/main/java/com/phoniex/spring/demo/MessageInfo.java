package com.phoniex.spring.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MessageInfo {
    @Getter @Setter
    private String from;
    private String to;
    private String message;


}
