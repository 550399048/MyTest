package com.example.wucaiyan.mytest;

import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by wucaiyan on 17-6-9.
 */
public class AlgorithmTest {
    private static final String TAG = "";

    private void fun1() {
        Log.d(TAG, "fun1() called");
        long i = 1;
        long j = 1;
        long n = 0;
        ArrayList<Long> sum = new ArrayList<>();
        sum.add(i);
        sum.add(j);
        for (int m = 0; m < 20; m++) {
            n = i + j;
            sum.add(n);
            i = j;
            j = n;
        }
        Log.d(TAG, "fun1: " + sum.toString());
    }

    private void fun2() {
        Log.d(TAG, "fun2() called");
        ArrayList<Integer> sum = new ArrayList<>();
        for (int m = 1; m < 20; m++) {
            sum.add(f(m));
        }
        Log.d(TAG, "fun2: " + sum.toString());
    }

    private int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}
