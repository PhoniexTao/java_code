package com.phoniex.spring.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class MessageInfo {
    @Getter @Setter
    private String from;
    @Getter
    private String to;
    @Getter
    private String message;


}
