package com.example.wucaiyan.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends Activity {
    private RecyclerView mRecyclerView;
    private ArrayList<Appel> mApples;
    private HomeAdapter mHomeAdapter;
    private LinearLayoutManager mLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        onCreatDatas();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeAdapter = new HomeAdapter(this,mApples);
        mRecyclerView.setAdapter(mHomeAdapter);
        //mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);


        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
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



    public void onCreatDatas(){
        mApples = new ArrayList<Appel>();
        for (int i= 0;i<100;i++){
            Appel apple = new Appel(0,""+i,""+i,""+i);
            mApples.add(apple);

        }
    }


}
