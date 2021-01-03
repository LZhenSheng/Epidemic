package com.example.epidemic.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epidemic.R;
import com.example.epidemic.activity.AddHealthReport;
import com.example.epidemic.adapter.HealthReportAdapter;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.util.LiteORMUtil;
import com.example.epidemic.util.ToastUtil;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/***
* 健康上报展示界面
* @author 胜利镇
* @time 2021/1/2
* @dec 
*/
public class HealthFrgament extends BaseTitleFragment {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.activity_main)
    PullToRefreshLayout pullToRefreshLayout;

    HealthReportAdapter adapter;
    @BindView(R.id.rv)
    RecyclerView rv;

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

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getContext());

        adapter=new HealthReportAdapter(R.layout.item_health_report);
        //尺寸固定
        rv.setHasFixedSize(true);

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getMainActivity());
        rv.setLayoutManager(layoutManager);
        rv.setNestedScrollingEnabled(false);
        //创建分割线
        DividerItemDecoration decoration=new DividerItemDecoration(getMainActivity(),RecyclerView.VERTICAL);
        //添加到控件
        //可以添加多个
        rv.addItemDecoration(decoration);

        //禁用嵌套滚动
        rv.setNestedScrollingEnabled(false);

        rv.setAdapter(adapter);
        fetchData();
    }

    private void fetchData() {
        List<HealthReport> list=orm.queryHealthReport();
        ToastUtil.successShortToast(list.size()+"");
        List<HealthReport> result=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            result.add(list.get(i));
        }
        adapter.replaceData(result);
    }

    @Override
    protected void initListener() {
        super.initListener();
        pullToRefreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fetchData();
                        // 结束刷新
                        pullToRefreshLayout.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fetchData();
                        // 结束加载更多
                        pullToRefreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

    }
}
