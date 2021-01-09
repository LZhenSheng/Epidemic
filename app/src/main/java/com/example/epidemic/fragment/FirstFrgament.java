package com.example.epidemic.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epidemic.R;
import com.example.epidemic.activity.AddHealthReport;
import com.example.epidemic.activity.ApplicationForReturningToSchoolActivity;
import com.example.epidemic.activity.ApplyForPassActivity;
import com.example.epidemic.activity.LeaveApplicationActivity;
import com.example.epidemic.activity.ScanActivity;
import com.example.epidemic.adapter.MessageAdapter;
import com.example.epidemic.adapter.TestAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class FirstFrgament extends BaseTitleFragment {

    int index=0;

    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.vp2)
    ViewPager vp2;

    MessageAdapter adapter;

    /**
     * 构造方法
     * <p>
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
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("首页");
        setTitleCenter(toolbar);
        //创建一个ArrayList<View>对将要轮转显示的View进行存储
        ArrayList<View> mList = new ArrayList<View>();
        //分别对两个View进行加载
        View page1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message1, null);
        View page2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message2, null);
        View page3 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message3, null);
        //针对第一个View中的Button进行加载，并设置点击监听。同样是使用page1，即第一个View加载控件

        //将两个page存入到ArrayList<View>中
        mList.add(page1);
        mList.add(page2);
        mList.add(page3);
        //如果ViewPager不为空则将适配器Adapter传入，同样是为了防止空指针
        if (vp != null) {
            vp.setAdapter(new TestAdapter(mList));
            //设置当前的pager为第一个Item
            vp.setCurrentItem(0);
        }

        //创建一个ArrayList<View>对将要轮转显示的View进行存储
        ArrayList<View> mList1 = new ArrayList<View>();
        //分别对两个View进行加载
        View page4 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message4, null);
        View page5 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message5, null);
        View page6 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_message6, null);
        //针对第一个View中的Button进行加载，并设置点击监听。同样是使用page1，即第一个View加载控件

        //将两个page存入到ArrayList<View>中
        mList1.add(page4);
        mList1.add(page5);
        mList1.add(page6);
        //如果ViewPager不为空则将适配器Adapter传入，同样是为了防止空指针
        if (vp2 != null) {
            vp2.setAdapter(new TestAdapter(mList1));
            //设置当前的pager为第一个Item
            vp2.setCurrentItem(0);
        }
    }

    @OnClick({R.id.scan, R.id.add_health_report, R.id.apply_leave, R.id.returning_school, R.id.apply_pass_check})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scan:
                startActivity(ScanActivity.class);
                break;
            case R.id.add_health_report:
                startActivity(AddHealthReport.class);
                break;
            case R.id.apply_leave:
                startActivity(LeaveApplicationActivity.class);
                break;
            case R.id.returning_school:
                startActivity(ApplicationForReturningToSchoolActivity.class);
                break;
            case R.id.apply_pass_check:
                startActivity(ApplyForPassActivity.class);
                break;
        }
    }
}
