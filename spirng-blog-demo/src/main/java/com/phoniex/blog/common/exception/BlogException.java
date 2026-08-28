package com.phoniex.blog.common.exception;


public class BlogException extends RuntimeException {
    private int code;
    private String errMsg;

    public BlogException(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }
}
