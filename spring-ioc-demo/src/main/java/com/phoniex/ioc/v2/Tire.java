package com.phoniex.ioc.v2;

public class Tire {
    int size;
    String color;
    public Tire(Integer size,String color) {
        this.size = size;
        this.color = color;
        System.out.println("tire init,size" + size);
    }
}
