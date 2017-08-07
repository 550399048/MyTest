package com.example.wucaiyan.mytest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wucaiyan on 17-7-20.
 */

public class AIDLActivity extends Activity implements View.OnClickListener {

    public IBookmanger mBookService = null;
    //标志当前与服务端连接状况的布尔值，false为未连接，true为连接中
    private boolean mBound = false;

    //包含Book对象的list
    private List<Book> mBooks;
    private Button mAidlBotton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_activity_layout);

        mAidlBotton = (Button)findViewById(R.id.test_aidl_text);
        mAidlBotton.setOnClickListener(this);
    }

    public void addBookView (){
        if (!mBound) {
            attempToBound();
            Toast.makeText(this, "当前与服务端处于未连接状态，正在尝试重连，请稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mBookService == null) {
            return;
        }

        Book book = new Book();
        book.setName("Android");
        book.setPrice(123);


        try {
            mBookService.addBook(book);
            Log.e(getLocalClassName(), book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    private void attempToBound() {
        Log.e("wcy","boundService");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.wucaiyan.mytest","com.example.wucaiyan.mytest.AIDLService"));

        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        mBound = true;

    }

    public ServiceConnection  mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(getLocalClassName(), "service connected");
            mBookService = IBookmanger.Stub.asInterface(service);
            mBound = true;

            if (mBookService != null) {
                try {
                    mBooks = mBookService.getBooksItem();
                    Log.e(getLocalClassName(),"from service get bookItem =" + mBooks);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(getLocalClassName(), "service disconnected");
            mBound = false;

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("wcy","onstart");
        if (!mBound) {
            attempToBound();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mServiceConnection);
            mBound = false;
        }
    }

    @Override
    public void onClick(View v) {
        addBookView();
    }
}
