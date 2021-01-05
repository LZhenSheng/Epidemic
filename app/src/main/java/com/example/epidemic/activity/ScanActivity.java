package com.example.epidemic.activity;


import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.ToastUtil;
import com.king.zxing.CaptureHelper;
import com.king.zxing.OnCaptureCallback;
import com.king.zxing.ViewfinderView;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;

public class ScanActivity extends BaseTitleActivity implements OnCaptureCallback {

    private static final String TAG = "ScanActivity";

    Handler handler=new Handler();

    /**
     * 扫描预览视图
     */
    @BindView(R.id.surfaceView)
    SurfaceView surfaceView;

    /**
     * 扫描框
     */
    @BindView(R.id.viewfinderView)
    ViewfinderView viewfinderView;

    /**
     * 扫描工具类
     */
    private CaptureHelper captureHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }

    @Override
    protected void initViews() {
        super.initViews();

        //显示亮色状态
//        lightStatusBar();
    }

    @Override
    public void initData() {
        super.initData();
        //创建扫描工具类
        captureHelper = new CaptureHelper(this, surfaceView, viewfinderView);

        //设置扫描结果回调
        captureHelper.setOnCaptureCallback(this);

        //设置支持连续扫描
        captureHelper.continuousScan(true);

        //执行创建
        captureHelper.onCreate();
    }

    /**
     * 界面显示了
     */
    @Override
    protected void onResume() {
        super.onResume();

        //开始扫描
        captureHelper.onResume();
    }

    /**
     * 界面暂停了
     */
    @Override
    protected void onPause() {
        super.onPause();

        //暂停扫描
        captureHelper.onPause();
    }

    /**
     * 界面销毁时
     */
    @Override
    protected void onDestroy() {
        //销毁扫描工具类
        captureHelper.onDestroy();

        super.onDestroy();
    }

    /**
     * 触摸事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件发生到扫描工具类
        captureHelper.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /**
     * 扫描结果回调
     *
     * @param result 扫描结果
     * @return 返回true表示拦截，将不自动执行后续逻辑，为false表示不拦截，默认不拦截
     */
    @Override
    public boolean onResultCallback(String result) {

        if (StringUtils.isNotBlank(result)) {
            //处理扫描结果
            ToastUtil.successShortToast(result);
        } else {
            //显示不支持该格式
            showNotSupportFormat();
        }

        //拦截结果
        return false;
    }

    /**
     * 显示不支持该格式
     */
    private void showNotSupportFormat() {
        //先暂停
        captureHelper.onPause();

        ToastUtil.errorShortToast(R.string.error_not_support_qrcode_format);

        //延迟后启用扫描
        //目的是防止持续扫描不正确的二维码
        //可以根据需求调整
        viewfinderView.postDelayed(() -> captureHelper.onResume(), 800);
    }

    @Override
    protected void initListener() {
        super.initListener();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivityAfterFinishThis(LoginStudengActivity.class);
            }
        }, 1000);
    }
}
