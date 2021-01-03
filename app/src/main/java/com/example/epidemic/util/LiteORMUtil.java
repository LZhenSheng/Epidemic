package com.example.epidemic.util;

import android.content.Context;

import com.example.epidemic.liteorm.Account;
import com.example.epidemic.liteorm.HealthReport;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.List;

/**
 * LiteOrm数据库工具类
 */
public class LiteORMUtil {
    /**
     * 数据库工具类实例
     */
    private static LiteORMUtil instance;

    /**
     * 上下文
     */
    private final Context context;

    /**
     * 数据库实例
     */
    private final LiteOrm orm;

    /**
     * 构造方法
     *
     * @param context
     */
    private LiteORMUtil(Context context) {
        this.context = context;

        //获取偏好设置工具类
        PreferenceUtil sp = PreferenceUtil.getInstance(context);

        //创建数据库实例
        String databaseName = String.format("%s.db", "PreferenceUtil.getObjectID())");
        orm = LiteOrm.newSingleInstance(context, databaseName);

        //设置调试模式
        orm.setDebugged(LogUtil.isDebug);
    }

    /**
     * 获取数据库工具类单例
     *
     * @param context
     * @return
     */
    public static LiteORMUtil getInstance(Context context) {
        if (instance == null) {
            instance = new LiteORMUtil(context.getApplicationContext());
        }
        return instance;
    }

    /**
     * 创建账户
     *
     */
    public void createAccount(String account,String password) {
        Account account1=new Account();
        account1.setAccount(account);
        account1.setPassword(password);
        orm.save(account1);
    }

    /**
     * 创建健康上报表
     *
     */
    public void createHealthReport(HealthReport data) {
        orm.save(data);
    }

    /**
     * 查询所有账号
     *
     * @return
     */
    public Account queryAccountByIphonePassword(String ihpone,String password) {
        QueryBuilder<Account> queryBuilder = new QueryBuilder<>(Account.class);
        List<Account> list=orm.query(queryBuilder);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getAccount().equals(ihpone)&&list.get(i).getPassword().equals(password)){
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * 查询所有账号
     *
     * @return
     */
    public List<HealthReport> queryHealthReport() {
        QueryBuilder<HealthReport> queryBuilder = new QueryBuilder<>(HealthReport.class);
        return orm.query(queryBuilder);
    }
}
