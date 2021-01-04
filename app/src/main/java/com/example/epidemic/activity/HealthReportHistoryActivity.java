package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.adapter.HealthReportAdapter;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.util.LiteORMUtil;
import com.example.epidemic.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HealthReportHistoryActivity extends BaseTitleActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.rv)
    RecyclerView rv;

    HealthReportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_report);
    }

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getApplicationContext());

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

}
