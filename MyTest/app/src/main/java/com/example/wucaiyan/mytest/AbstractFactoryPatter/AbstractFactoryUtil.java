package com.example.wucaiyan.mytest.AbstractFactoryPatter;

/**
 * Created by wucaiyan on 17-7-3.
 */

public class AbstractFactoryUtil {
    public static void run () {
        System.out.println("执行抽象工厂模式");
        FactoryBMW320 abstractFactory = new FactoryBMW320();
        abstractFactory.createEngine();
        abstractFactory.createAirCondition();

        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAirCondition();
    }
}
