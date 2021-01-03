package com.example.epidemic.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;

/**
 * 偏好设计工具类
 * 是否登录了，是否显示引导界面，用户Id
 */
public class PreferenceUtil {

    /***
     * 患者最近情况图片资源地址
     */
    private static String SITUATION="SITUATION";

    /***
     * 常量
     */
    private static String NUM="NUM";
    /***
     * 省
     */
    private static String PROVINCE="PROVINCE";
    /***
    * phone用于简介与聊天界面跳转
    */
    private static String PHONE="PHONE";
    /***
     * 市
     */
    private static String CITY="CITY";
    /***
     * 地区
     */
    private static String AREA="AREA";
    /***
    * 个人简介
    */
    private static String DESCRIPTION="DESCRIPTION";
    /***
     * 捐赠跳转相关
     */
//    private static String FUNDRAISING="FUNDRAISING";
    /***
     * 客服
     */
    private static String CUSTOMERSERVICE="CUSTOMERSERVICE";
    /***
     * 捐赠跳转相关
     */
    private static String FLAG="FLAG";

    /**
     * 实例
     * 单例
     */
    private static PreferenceUtil instance;

    /***
     * 身份证临时uri保存
     */
    private static String CREDIDURI="CREDIDURI";

    /***
     * Bmob查询保存结果状态为
     */
    private static String RESULT="RESULT";

    /**
     * 偏好设置文件名称
     */
    private static final String NAME = "CHARITABLE";

    /**
     * 是否显示引导界面标记
     */
    private static final String SHOW_GUIDE = "SHOW_GUIDE";

    /**
     * 用户登录标记
     */
    private static final String SESSION = "SESSION";

    /***
     * 用户头像
     */
    private static final String USER_URI="USER_URI";

    /***
     * 用户昵称
     */
    private static final String USER_NICK_NAME="USER_NICK_NAME";

    /***
     * 用户性别
     */
    private static final String USER_SEX="USER_SEX";

    /**
     * 用户ID
     * 手机号
     */
    private static final String USER_ID = "USER_ID";

    /**
     * 管理员ID
     */
    private static final String ADMINISOTR_ID="ADMINISOTR_ID";

    /**
     * 用户ID
     * 手机号
     */
    private static final String USER_PASSWORD = "USER_PASSWORD";

    /**
     * 上下文
     */
    private final Context context;
    private static SharedPreferences preference;
    /***
     * 用户位移ID
     */
    private static final String USER_OBJECTID="USER_OBJECTID";

    /***
     * 保存Account
     */
    private static final String SAVE_ACCOUNT="SAVE_ACCOUNT";

    /***
     * 暂存
     */
    private static final String TEMPORARY_STORAGE="SAVE_ACCOUNT";

    /***
     * 暂存
     */
    private static final String TEMPORARY="TEMPORARY";

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
    public static boolean isShowGuide() {
        return getBoolean(SHOW_GUIDE);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public static void setShowGuide(boolean value) {
        putBoolean(SHOW_GUIDE, value);
    }

    /***
     * 退出登录删除账号密码
     */
    public static void onLoginOut() {
        delete(USER_ID);
        delete(USER_PASSWORD);
    }

    /***
     * 保存账号密码
     */
    public static void onSaveAccount(String account,String password) {
        putString(USER_PASSWORD,password);
        putString(USER_ID,account);
    }

    /***
     * 读取账号
     */
    public static String getUserID() {
        return getString(USER_ID);
    }

    /**
     * 读取密码
     */
    public static String getUserPassword() {
        return getString(USER_PASSWORD);
    }

    /***
     * 设置登录状态
     */
    public static void saveSession(boolean flag) {
        putBoolean(SESSION,flag);
    }

    /**
     * 获取
     */
    public static String getPhone() {
        return getString(PHONE);
    }

    /***
     * 保存手机
     */
    public static void savePhone(String flag) {
        putString(PHONE,flag);
    }

    /**
     * 获取用户头像
     */
    public static String getUserUri() {
        return getString(USER_URI);
    }

    /***
     * 设置用户昵称
     */
    public static void saveUserNickName(String objectID) {
        putString(USER_NICK_NAME,objectID);
    }
    /**
     * 身份证照片保存
     */
    public static int getNum() {
        return getInt(NUM);
    }
    /***
     * 身份证照片获取
     */
    public static void saveNum(int objectID) {
        putInt(NUM,objectID);
    }
    /**
     * 身份证照片保存
     */
    public static String getCreditIdUri() {
        return getString(CREDIDURI);
    }
    /***
     * 身份证照片获取
     */
    public static void saveCreditIdUri(String objectID) {
        putString(CREDIDURI,objectID);
    }
    /**
     * 获取用户昵称
     */
    public static String getUserNickName() {
        return getString(USER_NICK_NAME);
    }
    /***
     * 设置用户姓名
     */
    public static void saveFlag(String objectID) {
        putString(FLAG,objectID);
    }
    /**
     * 获取用户姓名
     */
    public static String getFlag() {
        return getString(FLAG);
    }
    /***
     * 设置用户姓名
     */
//    public static void saveFundraising(String objectID) {
//        putString(FUNDRAISING,objectID);
//    }
    /**
     * 获取用户姓名
     */
//    public static String getFundraising() {
//        return getString(FUNDRAISING);
//    }

    /***
     * 设置用户性别
     */
    public static void saveUserSex(String objectID) {
        putString(USER_SEX,objectID);
    }
    /**
     * 获取用户账户
     */
    public static String getUserAccount() {
        return getString(USER_ID);
    }
    /***
     * 设置用户账户
     */
    public static void saveUserAccount(String objectID) {
        putString(USER_ID,objectID);
    }
    /**
     * 获取用户性别
     */
    public static String getUserSex() {
        return getString(USER_SEX);
    }

    /***
     * 设置用户头像
     */
    public static void saveUserUri(String objectID) {
        putString(USER_URI,objectID);
    }
    /**
     * 获取用户ID
     */
    public static String getObjectID() {
        return getString(USER_OBJECTID);
    }

    /***
     * 设置用户ID
     */
    public static void saveObjectID(String objectID) {
        putString(USER_OBJECTID,objectID);
    }
    /**
     * 获取登录状态
     */
    public static boolean getSession() {
        return getBoolean(SESSION);
    }
    /***
     * 设置操作结果
     * @param result
     */
    public static void setBmobResult(boolean result) {
        putBoolean(RESULT,result);
    }

    public static boolean getBmobResult() {
        return getBoolean(RESULT);
    }

    /***
     * 保存设置数据读取
     */
    public static void saveAccountPassword(String account,String password){
        if(account!=null&&password!=null){
            PreferenceUtil.onSaveAccount(account,password);
        }
    }

    /***
     * 用户描述相关
     * @param description
     */
    public static void saveDescription(String description){
        putString(DESCRIPTION,description);
    }

    public static String getDescription(){
        return getString(DESCRIPTION);
    }
    /***
     * 省相关
     */
    public static void saveProvince(String province){
        putString(PROVINCE,province);
    }

    public static String getProvince(){
        return getString(PROVINCE);
    }

    /***
     * 市相关
     */
    public static void saveCity(String city){
        putString(CITY,city);
    }

    public static String getCity(){
        return getString(PROVINCE);
    }

    /***
     * 地区相关
     */
    public static void saveArea(String area){
        putString(AREA,area);
    }

    public static String getArea(){
        return getString(AREA);
    }

    /***
     * 存储客服ID
     * @param description
     */
    public static void saveCustomberService(String description){
        putString(CUSTOMERSERVICE,description);
    }

    public static String getCustomberService(){
        return getString(CUSTOMERSERVICE);
    }
    /***
     * 管理员ID相关
     * @param description
     */
    public static void saveAdminisotrID(String description){
        putString(ADMINISOTR_ID,description);
    }

    public static String getAdminisotrID(){
        return getString(ADMINISOTR_ID);
    }

    /***
     * 暂存相关
     * @param description
     */
    public static void saveTemporaryStorage(boolean description){
        putBoolean(TEMPORARY_STORAGE,description);
    }
    public static boolean getTemporaryStorage(){
        return getBoolean(TEMPORARY_STORAGE);
    }

    /***
     * 暂存相关
     * @param description
     */
    public static void saveSituation(String description){
        putString(SITUATION,description);
    }
    public static String getSituation(){
        return getString(SITUATION);
    }

    /***
     * 设置用户姓名
     */
    public static void saveTemporary(String objectID) {
        putString(TEMPORARY,objectID);
    }
    /**
     * 获取用户姓名
     */
    public static String getTemporary() {
        return getString(TEMPORARY);
    }
}
