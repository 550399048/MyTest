package com.example.wucaiyan.mytest.AbstractFactoryPatter;

/**
 * Created by wucaiyan on 17-7-3.
 */

public class FactoryBMW523 implements AbstractFactory {
    public FactoryBMW523(){
        System.out.println("宝马523工厂");
    }
    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public AirConditon createAirCondition() {
        return new AirConditionB();
    }
}
