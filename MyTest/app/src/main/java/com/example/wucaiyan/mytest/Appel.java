package com.example.wucaiyan.mytest;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wucaiyan on 17-5-27.
 */

public class Appel {
    private int mImageView;
    private String mTitle;
    private String mSummary;
    private String mMessage;

    public Appel (){


    }

    public Appel(int mImageView, String mTitle, String mSummary, String mMessage) {
        this.mImageView = mImageView;
        this.mTitle = mTitle;
        this.mSummary = mSummary;
        this.mMessage = mMessage;
    }

    public int getmImageView() {
        return mImageView;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSummary() {
        return mSummary;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmImageView(int mImageView) {
        this.mImageView = mImageView;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    @Override
    public String toString() {
        return "Appel{" +
                "mImageView=" + mImageView +
                ", mTitle='" + mTitle + '\'' +
                ", mSummary='" + mSummary + '\'' +
                ", mMessage='" + mMessage + '\'' +
                '}';
    }
}
