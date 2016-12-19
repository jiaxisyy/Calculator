package com.example.shuangxiang.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by shuang.xiang on 2016/12/19.
 */
public class HistoryActivity extends Activity {
    private static final String TAG = "HistoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initData();

    }

    private void initData() {

        StatisticsDao dao = MyApplication.getInstances().getDaoSession().getStatisticsDao();
        List<Statistics> statisticses = dao.loadAll();
        RecyclerView rvHistory = (RecyclerView) findViewById(R.id.rv_history);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.setAdapter(new HistoryAdapter(this, statisticses));
        //这句就是添加我们自定义的分隔线
        rvHistory.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
