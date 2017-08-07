package com.example.wucaiyan.mytest.BridgeMode.Entity;

import com.example.wucaiyan.mytest.BridgeMode.AbstractRoad;

/**
 * Created by wucaiyan on 17-6-30.
 */

public class Street extends AbstractRoad {
    private final static String TAG="Street";
    @Override
    public void run() {
        mAbstractCar.run();
        System.out.println("在市区街道行驶");
    }
}
