package com.example.wucaiyan.mytest.AbstractFactoryPatter;

/**
 * Created by wucaiyan on 17-7-3.
 */

public interface AbstractFactory {
    //制造发动机
    public Engine createEngine();
    //制造空调
    public AirConditon createAirCondition();
}
