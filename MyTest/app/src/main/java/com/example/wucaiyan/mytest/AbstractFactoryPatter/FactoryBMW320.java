package com.example.wucaiyan.mytest.AbstractFactoryPatter;

/**
 * Created by wucaiyan on 17-7-3.
 */

public class FactoryBMW320 implements AbstractFactory {
    public FactoryBMW320(){
        System.out.println("宝马320");
    }
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public AirConditon createAirCondition() {
        return new AirConditionA();
    }
}
