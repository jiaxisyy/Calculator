package com.example.shuangxiang.calculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shuang.xiang on 2016/12/19.
 */

public class HistoryAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Statistics> mList;

    public HistoryAdapter(Context context, List<Statistics> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myHolder = (MyViewHolder) holder;
        myHolder.ad.setText(mList.get(position).getAd()+"");
        myHolder.da.setText(mList.get(position).getDa()+"");
        myHolder.tc.setText(mList.get(position).getTc()+"");
        myHolder.pt.setText(mList.get(position).getPt()+"");
        myHolder.item08T.setText(mList.get(position).getE08X08T()+"");
        myHolder.item08R.setText(mList.get(position).getE08X08R()+"");
        myHolder.item16X.setText(mList.get(position).getE16X()+"");
        myHolder.item16T.setText(mList.get(position).getE16T()+"");
        myHolder.item16R.setText(mList.get(position).getE16R()+"");
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ad, da, tc, pt, item08T, item08R, item16X, item16T, item16R;

        public MyViewHolder(View itemView) {
            super(itemView);
            ad = (TextView) itemView.findViewById(R.id.item_ad);
            da = (TextView) itemView.findViewById(R.id.item_da);
            tc = (TextView) itemView.findViewById(R.id.item_tc);
            pt = (TextView) itemView.findViewById(R.id.item_pt);
            item08T = (TextView) itemView.findViewById(R.id.item_08T);
            item08R = (TextView) itemView.findViewById(R.id.item_08R);
            item16X = (TextView) itemView.findViewById(R.id.item_16X);
            item16T = (TextView) itemView.findViewById(R.id.item_16T);
            item16R = (TextView) itemView.findViewById(R.id.item_16R);
        }
    }
}
