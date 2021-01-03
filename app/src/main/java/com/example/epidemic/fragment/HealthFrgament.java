package com.example.epidemic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.epidemic.R;
import com.example.epidemic.activity.AddHealthReport;

import butterknife.BindView;
import butterknife.OnClick;


/***
* 健康上报展示界面
* @author 胜利镇
* @time 2021/1/2
* @dec 
*/
public class HealthFrgament extends BaseTitleFragment {


    @OnClick(R.id.addHealthReport)
    public void onClick(){
        startActivity(AddHealthReport.class);
    }

    /**
     * 构造方法
     *
     * 固定写法
     *
     * @return
     */
    public static HealthFrgament newInstance() {
        Bundle args = new Bundle();

        HealthFrgament fragment = new HealthFrgament();
        fragment.setArguments(args);
        return fragment;
    }

    /***
     * 获取View
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_health_frgament,container,false);
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("健康");
        setTitleCenter(toolbar);
    }

}
