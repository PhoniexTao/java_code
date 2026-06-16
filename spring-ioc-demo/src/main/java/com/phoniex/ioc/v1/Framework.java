package com.phoniex.ioc.v1;

public class Framework {
    private Bottom bottom;

    public Framework(Integer size) {
        this.bottom = new Bottom(size);
        System.out.println("framework init...");
    }
}
