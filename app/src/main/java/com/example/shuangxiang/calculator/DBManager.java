package com.example.shuangxiang.calculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by lax on 2016/12/18.
 */

public class DBManager {
    private final static String dbName = "statistics_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }
    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }
    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }
    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insertUser(Statistics user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StatisticsDao userDao = daoSession.getStatisticsDao();
        userDao.insert(user);
    }
    /**
     * 查询用户列表
     */
    public List<Statistics> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StatisticsDao userDao = daoSession.getStatisticsDao();
        QueryBuilder<Statistics> qb = userDao.queryBuilder();
        List<Statistics> list = qb.list();
        return list;
    }
}
