package com.example.epidemic.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;

/**
 * 偏好设计工具类
 * 是否登录了，是否显示引导界面，用户Id
 */
public class PreferenceUtil {

    /**
     * 实例
     * 单例
     */
    private static PreferenceUtil instance;

    /**
     * 偏好设置文件名称
     */
    private static final String SESSION = "SESSION";

    /**
     * 偏好设置文件名称
     */
    private static final String OBJECTID = "SESSION";

    /**
     * 偏好设置文件名称
     */
    private static final String NAME = "CHARITABLE";

    /**
     * 偏好设置文件名称
     */
    private static final String TYPE = "TYPE";

    /**
     * 是否显示引导界面标记
     */
    private static final String SHOW_GUIDE = "SHOW_GUIDE";

    /**
     * 上下文
     */
    private final Context context;
    private static SharedPreferences preference;

    /**
     * 构造方法
     * @param context
     */
    public PreferenceUtil(Context context) {
        //保存上下文
        this.context=context.getApplicationContext();

        //这样写有内存泄漏
        //因为当前工具类不会马上释放
        //如果当前工具类引用了界面实例
        //当界面关闭后
        //因为界面对应在这里还有引用
        //所以会导致界面对象不会被释放
        //this.context = context;

        //获取偏好设置
        preference = this.context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    /**
     * 获取偏好设置单例
     * @param context
     * @return
     */
    public static PreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance=new PreferenceUtil(context);
        }
        return instance;
    }

    /**
     * 保存字符串
     *
     * @param key
     * @param value
     */
    private static void putString(String key, String value) {
        preference.edit().putString(key, value).commit();
    }

    /***
     * 获取字符串
     */
    private static String getString(String key) {
        return preference.getString(key,null);
    }
    /**
     * 保存boolean
     *
     * @param key
     * @param value
     */
    private static void putBoolean(String key, boolean value) {
        preference.edit().putBoolean(key, value).commit();
    }

    /***
     * 获取boolean
     * @param key
     * @return
     */
    private static boolean getBoolean(String key) {
        return preference.getBoolean(key, false);
    }

    /**
     * 删除内容
     *
     * @param key
     */
    private static void delete(String key) {
        preference.edit().remove(key).commit();
    }

    /***
     * 获取一个int
     * @param key
     * @return
     */
    private static int getInt(String key) {
        return preference.getInt(key, 0);
    }

    /**
     * 设置一个int
     *
     * @param key
     * @param data
     */
    private static void putInt(String key, int data) {
        preference.edit().putInt(key, data).apply();
    }

    /**
     * 是否显示引导界面
     * @return
     */
    public static boolean getSession() {
        return getBoolean(SHOW_GUIDE);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public static void setSession(boolean value) {
        putBoolean(SESSION, value);
    }

    /**
     * 是否显示引导界面
     * @return
     */
    public static String getObjectId() {
        return getString(OBJECTID);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public static void setObjectId(String value) {
        putString(OBJECTID, value);
    }

    /**
     * 是否显示引导界面
     * @return
     */
    public static String getType() {
        return getString(TYPE);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public static void setType(String value) {
        putString(TYPE, value);
    }

}
