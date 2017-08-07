package com.example.wucaiyan.mytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.wucaiyan.mytest.AbstractFactoryPatter.AbstractFactoryUtil;
import com.example.wucaiyan.mytest.BridgeMode.Utils;
import com.example.wucaiyan.mytest.javatest.Outer;

import java.util.Vector;

import custome.PasswordView;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button mRecyclerViewButton;
    private Context mContent;
    private Button mInputMethod;
    private int[] a={10,01,10,01,10,01,10,01,10,01,01};
    private Button mtestAidl;

    public Vector<Outer> mVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mContent = getApplicationContext();
        button1 = (Button) findViewById(R.id.callBack);
        button2 = (Button) findViewById(R.id.unCallback);
        mInputMethod = (Button) findViewById(R.id.test_InputMethod);
        mRecyclerViewButton = (Button) findViewById(R.id.test_RecyclerView);
        mtestAidl = (Button)findViewById(R.id.test_aidl);
        PasswordView mPasswordView = (PasswordView) findViewById(R.id.customView);


        InputMethodManager inputManager = (InputMethodManager)mPasswordView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(mPasswordView, 0);
        mPasswordView.setFocusable(true);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        mRecyclerViewButton.setOnClickListener(this);
        mInputMethod.setOnClickListener(this);
        mtestAidl.setOnClickListener(this);
        mPasswordView.setOnClickListener(this);
        Utils.print();

        AbstractFactoryUtil.run();

        tryCatchFinally();
    }

    private void tryCatchFinally() {
        try {
            Log.d("wcy","执行 try代码块");
            int jj = a[11];

        }catch (Exception exacaption) {

            Log.d("wcy","执行ecaption catch");

        } finally {
            Log.d("wcy" ,"执行finally");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent();
        switch (view.getId()) {

            case R.id.callBack:
                intent= new Intent();
                intent.setAction("android.intent.action.EMERGENCY_CALLBACK_MODE_CHANGED");
                mContent.sendBroadcast(intent);
                break;
            case R.id.unCallback:
                solution2(a);
                break;
            case R.id.test_RecyclerView:
                intent.setClass(MainActivity.this, RecyclerViewActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.test_InputMethod:
                intent.setClass(MainActivity.this, InputMethod.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.test_aidl:
                intent.setClass(MainActivity.this,AIDLActivity.class);
                MainActivity.this.startActivity(intent);


        }

    }


    public int solution(int[] a) {
        int temp=-1;
        for (int i= 0 ;i<a.length;i++){
            temp = a[i];
            if (a[i] == -1) {
                continue;
            }

            for (int j=i+1; j <=a.length-1;j++){
                Log.d("WCY","a["+i+"]="+a[i]+",a["+j+"]="+a[j]);

                if (a[j] == -1) {
                    continue;
                }

                if (a[i] == a[j]) {
                    a[i] =-1;
                    a[j] = -1;
                    temp = -1;
                    break;
                }
            }

            if (temp != -1) {
                Log.d("WCY","a[i]="+temp);
               break;
            }

        }
        Log.d("WCY","TEMP="+temp);
        return temp;
    }

    public int solution2(int[] A ){
        int temp = A[0];
        for(int i=1;i<A.length;i++) {
            temp = temp^A[i];
        }
        Log.d("WCY","temp="+temp);
        return temp;
    }

}



