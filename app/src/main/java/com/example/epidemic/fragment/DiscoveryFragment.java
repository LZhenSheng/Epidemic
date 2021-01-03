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

public class DiscoveryFragment extends BaseTitleFragment {

    /**
     * 构造方法
     *
     * 固定写法
     *
     * @return
     */
    public static DiscoveryFragment newInstance() {
        Bundle args = new Bundle();

        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /***
     * 获取View
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discovery,container,false);
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("足迹");
        setTitleCenter(toolbar);
    }

}
