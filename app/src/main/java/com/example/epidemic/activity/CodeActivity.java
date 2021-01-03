package com.example.epidemic.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.DensityUtil;
import com.example.epidemic.util.ToastUtil;
import com.king.zxing.util.CodeUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class CodeActivity extends BaseTitleActivity {

    /**
     * 二维码
     */
    @BindView(R.id.iv_code)
    ImageView iv_code;

    /***
     * 为各控件注册点击事件
     * @param view
     */
    @OnClick({R.id.save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.save:
                ToastUtil.successShortToast("已保存到本地");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
    }


    @Override
    public void initData() {
        super.initData();
        Bitmap bitmap = CodeUtils.createQRCode("data" , DensityUtil.dip2px(getMainActivity(), 300));
        //显示二维码
        iv_code.setImageBitmap(bitmap);
    }
}
