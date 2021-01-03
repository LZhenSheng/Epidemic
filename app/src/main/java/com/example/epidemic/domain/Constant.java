package com.example.epidemic.domain;


/**
 * 常量类
 */
public class Constant {

    /**
     * 聊天消息通知点击
     */
    public static final String ACTION_MESSAGE = "com.ixuea.courses.mymusic.ACTION_MESSAGE";

    /**
     * 左侧（其他人）文本消息
     */
    public static final int TYPE_TEXT_LEFT = 100;

    /**
     * 右侧（我的）文本消息
     */
    public static final int TYPE_TEXT_RIGHT = 110;

    /**
     * 左侧（其他人）图片消息
     */
    public static final int TYPE_IMAGE_LEFT = 120;

    /**
     * 右侧（我的）图片消息
     */
    public static final int TYPE_IMAGE_RIGHT = 130;

    /***
    * 默认头像
    */
    public static final String avator="https://bmob-cdn-28709.bmobpay.com/2020/08/21/d7e58005407dd02d8055f01ef3dae9b8.png";
    /***
     * 用户
     */
    public static final int TYPE_USER=3;
    /***
     * 话题
     */
    public static final int TYPE_TOPIC=3;


    /**
     * mention开始
     */
    public static final String MENTION = "@";

    /**
     * hashTag开始
     */
    public static final String HAST_TAG = "#";

    public static final String ID ="ID" ;
    public static final String RESOURCE_ENDPOINT ="http://" ;

    /**
     * 扫描二维码界面请求码
     */
    public static final int REQUEST_SCAN_CODE = 300;

    /***
     * 评论跳转传递常量
     */
    public static final String COMMENT_ID = "COMMENT_ID";

    /**
     * 传递标题 key
     */
    public static final String TITLE = "TITLE";

    /***
     * 评论列表默认返回数量
     */
    public static final int DEFAULT_PAGE_SIZE =10;
    public static final String NICKNAME ="NICKNAME" ;

    /**
     * 腾讯Bugly
     */
    public static final String BUGLY_APP_KEY = "bce455dde6";

    /***
     * 评价等级常量
     */
    public static int PICTURE_STATUS1=0;
    public static int PICTURE_STATUS2=0;
    public static int PICTURE_STATUS3=0;
    public static int PICTURE_STATUS4=0;
    public static int PICTURE_STATUS5=0;

    /**
     * 60s
     */
    public static final int MUSIC_FILTER_DURATION = 60 * 1000;

    /**
     * 手机号正则表达式
     * 移动：134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188 198
     * 联通：130 131 132 145 155 156 166 171 175 176 185 186
     * 电信：133 149 153 173 177 180 181 189 199
     * 虚拟运营商: 170
     */
    public static final String REGEX_PHONE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";


    /***
     * 默认头像地址
     */
    public static final String URI="https://bmob-cdn-28709.bmobpay.com/2020/06/28/3b2ce86940d953b0808e3b8bf9101eef.png";

}
