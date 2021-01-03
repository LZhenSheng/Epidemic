package com.example.epidemic.activity.base;

import android.os.Handler;

public class BaseTimeTitleActivity extends BaseTitleActivity {
    /**
     * handler
     */
    Handler handler=new Handler();

    /***
     * 演示1秒
     */
    protected void timeOutFor1000() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 1000);
    }

    /***
     * 演示0.5秒
     */
    protected void timeOutFor500() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 500);
    }


    /***
     * 演示关闭
     */
    protected void timeConsumingOperationFeedBack() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }

    @Override
    public void initData() {
        super.initData();
//        lightStatusBar();
    }
}
