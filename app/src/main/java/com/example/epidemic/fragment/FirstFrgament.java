package com.example.epidemic.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epidemic.R;
import com.example.epidemic.activity.ScanActivity;
import com.example.epidemic.util.ClickUtil;


public class FirstFrgament extends BaseTitleFragment {

    /**
     * 构造方法
     *
     * 固定写法
     *
     * @return
     */
    public static FirstFrgament newInstance() {
        Bundle args = new Bundle();

        FirstFrgament fragment = new FirstFrgament();
        fragment.setArguments(args);
        return fragment;
    }

    /***
     * 获取View
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first,container,false);
    }


    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.drawable.scanning);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ClickUtil.isFastClick()){
                    return;
                }
                startActivity(ScanActivity.class);
            }
        });
        setTitleCenter(toolbar);
    }
}
