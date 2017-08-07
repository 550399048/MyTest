package com.example.wucaiyan.mytest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * TODO: document your custom view class.
 */
public class CustomDialog extends AlertDialog {
    static final int BUTTON_SUBMIT = DialogInterface.BUTTON_POSITIVE;
    static final int BUTTON_FORGET = DialogInterface.BUTTON_NEUTRAL;
    static final String TAG = "WifiDialog";


    private View mView;
    private boolean mHideSubmitButton;
    private int password_length = 64;

    protected CustomDialog(Context context) {
        super(context);

    }

    protected CustomDialog(Context context, @StyleRes int theme) {
        super(context, theme);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInverseBackgroundForced(true);
    }




    public static int getButtonSubmit() {
        return BUTTON_SUBMIT;
    }




    public Button getForgetButton() {
        return getButton(BUTTON_FORGET);
    }


    public Button getCancelButton() {
        return getButton(BUTTON_NEGATIVE);
    }

}
