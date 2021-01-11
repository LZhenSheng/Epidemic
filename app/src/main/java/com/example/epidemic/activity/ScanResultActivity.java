package com.example.epidemic.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.BitmapUtil;
import com.google.zxing.WriterException;

import butterknife.BindView;

public class ScanResultActivity extends BaseTitleActivity {

    @BindView(R.id.avator)
    ImageView avator;

    @BindView(R.id.iv_code)
    ImageView iv_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
    }

    @Override
    public void initData() {
        super.initData();

        Glide.with(getMainActivity()).load("http://bmob-cdn-28709.bmobpay.com/2020/09/27/eebf2bf6d3aa4e29aafb5f521b33423a.jpg").into(avator);

        Bitmap bitmap = BitmapUtil.gainBitmap(getApplicationContext(),R.drawable.logo_login);
        //加头像把头像放到二维码里 1.头像2.获取要转化成二维码的信息3.宽4.高
        try {
            bitmap = BitmapUtil.makeQRImage(bitmap, "trim", 400, 400);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        //根据要转化成二维码的信息的多少定义生成二维码的大小
        // bitmap = BitmapUtil.makeQRImage(trim,400,400);
        if (bitmap != null) {
            //给image赋值
            iv_code.setImageBitmap(bitmap);
        }
    }


}
