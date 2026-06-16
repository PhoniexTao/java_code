package com.phoniex.ioc.v1;

public class Tire {
    int size;

    public Tire(Integer size) {
        this.size = size;
        System.out.println("tire init,size" + size);
    }
}
