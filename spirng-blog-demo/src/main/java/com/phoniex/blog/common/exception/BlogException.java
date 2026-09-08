package com.phoniex.blog.common.exception;


public class BlogException extends RuntimeException {
    private int code;
    private String errMsg;

    public BlogException(String errMsg) {
        super(errMsg);
        this.code = -1;
    }
    public BlogException(int code,String errMsg){
        super(errMsg);
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
