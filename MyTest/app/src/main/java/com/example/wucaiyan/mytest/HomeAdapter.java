package com.example.wucaiyan.mytest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.wucaiyan.mytest.R.drawable.qqq;

/**
 * Created by wucaiyan on 17-5-27.
 */

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList<Appel> mAppleList;
    private int[] firstVisibleItems = null;

    public HomeAdapter (Context context,ArrayList<Appel> appleList){
        mContext = context;
        mAppleList = appleList;
        Log.d("wcy","list="+mAppleList.toString());

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.test_layout, null,
                false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //if(((Appel) mAppleList.get(position)).getmTitle() != null){
        holder.title.setText(((Appel) mAppleList.get(position)).getmTitle());
           // }

        holder.imageView.setImageResource(R.drawable.qqq);
        //if (((Appel) mAppleList.get(position)).getmSummary()!= null){
        holder.summary.setText(((Appel) mAppleList.get(position)).getmSummary());
        //if(((Appel) mAppleList.get(position)).getmMessage()!= null){
        holder.message.setText(((Appel) mAppleList.get(position)).getmMessage());
    }

    @Override
    public int getItemCount() {
        return mAppleList.size();
    }

    class MyViewHolder extends ViewHolder {
         TextView message;
         ImageView imageView;
         TextView title;
         TextView summary;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.customicon);
            title = (TextView) itemView.findViewById(R.id.title);
            summary = (TextView) itemView.findViewById(R.id.summary);
            message = (TextView) itemView.findViewById(R.id.message);
        }
    }
}
