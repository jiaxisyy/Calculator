package com.example.shuangxiang.calculator;

import android.app.Application;

/**
 * Created by lax on 2016/12/18.
 */

public class MyApplication extends Application {
    public DBManager instance;
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();

    }

    /**
     * 初始化数据库
     */
    private void initGreenDao() {

        instance = DBManager.getInstance(this);

    }
}
