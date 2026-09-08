package com.phoniex.blog.common.exception;


public class BlogException extends RuntimeException {
    private int code;
    private String errMsg;

    public BlogException(String errMsg) {
        this.code = -1;
        this.errMsg = errMsg;
    }
}
