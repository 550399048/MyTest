package com.example.wucaiyan.mytest.BridgeMode.Entity;

import com.example.wucaiyan.mytest.BridgeMode.AbstractCar;

import static java.sql.DriverManager.println;

/**
 * Created by wucaiyan on 17-6-30.
 */

public class Car extends AbstractCar {
    @Override
    public void run() {
        System.out.println("公交车");
    }
}
