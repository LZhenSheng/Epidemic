package com.example.epidemic.fragment;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.epidemic.R;
import com.example.epidemic.activity.ScanActivity;
import com.example.epidemic.adapter.TestAdapter;
import com.example.epidemic.util.ClickUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class DiscoveryFragment extends BaseTitleFragment {

    @BindView(R.id.left)
    LinearLayout left;

    @BindView(R.id.right)
    LinearLayout right;


    @BindView(R.id.left_text)
    TextView left_text;

    @BindView(R.id.right_text)
    TextView right_text;

    @BindView(R.id.vp)
    ViewPager vp;

    /**
     * 构造方法
     * <p>
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
        return inflater.inflate(R.layout.fragment_discovery, container, false);
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("足迹");
        setTitleCenter(toolbar);

        //创建一个ArrayList<View>对将要轮转显示的View进行存储
        ArrayList<View> mList = new ArrayList<View>();
        //分别对两个View进行加载
        View page2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_in_school, null);
        View page1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_outside_school, null);
        //针对第一个View中的Button进行加载，并设置点击监听。同样是使用page1，即第一个View加载控件

        //将两个page存入到ArrayList<View>中
        mList.add(page1);
        mList.add(page2);
        //如果ViewPager不为空则将适配器Adapter传入，同样是为了防止空指针
        if (vp != null) {
            vp.setAdapter(new TestAdapter(mList));
            //设置当前的pager为第一个Item
            vp.setCurrentItem(0);
        }
    }

    @OnClick({R.id.left, R.id.right})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left:
                left.setBackgroundResource(R.drawable.shape_border_left_selected);
                right.setBackgroundResource(R.drawable.shape_border_right_select);
                ColorStateList csl1 = getResources().getColorStateList(R.color.white);
                left_text.setTextColor(csl1);
                ColorStateList csl2 = getResources().getColorStateList(R.color.gray);
                right_text.setTextColor(csl2);
                vp.setCurrentItem(0);
                break;
            case R.id.right:
                left.setBackgroundResource(R.drawable.shape_border_left_select);
                right.setBackgroundResource(R.drawable.shape_border_right_selected);
                ColorStateList csl3 = getResources().getColorStateList(R.color.gray);
                left_text.setTextColor(csl3);
                ColorStateList csl4 = getResources().getColorStateList(R.color.white);
                right_text.setTextColor(csl4);
                vp.setCurrentItem(1);
                break;
        }
    }
}
