package com.phoniex.ioc.v1;

public class Bottom {
    private Tire tire;

    public Bottom(Integer size) {
        this.tire = new Tire(size);
        System.out.println("Bottom init");
    }
}
