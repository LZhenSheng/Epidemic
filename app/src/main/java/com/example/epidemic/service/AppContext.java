package com.example.epidemic.service;

import android.app.Activity;
import android.app.Application;

import com.example.epidemic.util.PreferenceUtil;
import com.example.epidemic.util.ToastUtil;

import java.lang.ref.WeakReference;

import es.dmoral.toasty.Toasty;

/***
* 全局配置文件
* @author 胜利镇
* @time 2020/8/6 22:45
*/
public class AppContext extends Application {

    /**
     * 当前activity引用
     * 通过弱引用保存
     * 不影响gc销毁该界面
     */
    private WeakReference<Activity> currentActivity;

    /**
     * 上下文
     */
    private static AppContext context;

    private static final String TAG = "AppContext";
    /**
     * 偏好设置
     * 存储离线数据和特殊标记位
     */
    private PreferenceUtil sp;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        //偏好设置初始化
        sp=PreferenceUtil.getInstance(getApplicationContext());

        //初始化Toast工具类
        Toasty.Config.getInstance().apply();

        //初始化toast工具类
        ToastUtil.init(getApplicationContext());

    }

    /**
     * 获取当前上下文
     *
     * @return
     */
    public static AppContext getInstance() {
        return context;
    }



}