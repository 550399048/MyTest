package com.example.wucaiyan.mytest.BridgeMode;

import com.example.wucaiyan.mytest.BridgeMode.Entity.Bus;
import com.example.wucaiyan.mytest.BridgeMode.Entity.SpeedWay;

/**
 * Created by wucaiyan on 17-6-30.
 */

public class Utils {

    static public void print() {
        AbstractRoad mSpesdWay = new SpeedWay();
        mSpesdWay.mAbstractCar = new Bus();
        mSpesdWay.run();
    }
}
