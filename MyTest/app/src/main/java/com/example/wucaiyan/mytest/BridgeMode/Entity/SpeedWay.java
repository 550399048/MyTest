package com.example.wucaiyan.mytest.BridgeMode.Entity;

import com.example.wucaiyan.mytest.BridgeMode.AbstractRoad;

/**
 * Created by wucaiyan on 17-6-30.
 */

public class SpeedWay extends AbstractRoad {
    private final static String TAG="SpeedWay";
    @Override
    public void run() {
        mAbstractCar.run();
        System.out.println("在高速公路上行驶");
    }
}
