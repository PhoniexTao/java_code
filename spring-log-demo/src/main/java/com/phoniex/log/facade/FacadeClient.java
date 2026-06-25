package com.phoniex.log.facade;

//门面系统的外观可以不实现接口，但是对应的方法要有
public class FacadeClient implements Light {
    //要调用多种子系统的方法我们要先创建对应的对象：(没有用springboot的方式来写，需要手动new对象）
    private LivingRoomLight livingRoomLight = new LivingRoomLight();
    private BedRoomLight bedRoomLight = new BedRoomLight();
    private HallLight hallLight = new HallLight();
    @Override
    public void on() {
        livingRoomLight.on();
        bedRoomLight.on();
        hallLight.on();
    }

    @Override
    public void off() {
        livingRoomLight.off();
        bedRoomLight.off();
        hallLight.off();
    }

}
