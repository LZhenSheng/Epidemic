package com.example.epidemic.activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.adapter.HealthReportAdapter;
import com.example.epidemic.adapter.PassCardAdapter;
import com.example.epidemic.domain.Constant;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.liteorm.PassCard;
import com.example.epidemic.util.LiteORMUtil;
import com.example.epidemic.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ApplyForPassActivity extends BaseTitleActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.rv)
    RecyclerView rv;

    PassCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_pass);
    }

    /**
     * 创建菜单方法
     *
     * 有点类似显示布局要写到onCreate方法一样
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单点击了回调
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivity(AddApplyForPassActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initViews() {
        super.initViews();

        orm = LiteORMUtil.getInstance(getApplicationContext());

        adapter=new PassCardAdapter(R.layout.item_pass_card);
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
        List<PassCard> list=orm.queryPassCard();
        List<PassCard> result=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            result.add(list.get(i));
        }
        adapter.replaceData(result);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent intent=new Intent(ApplyForPassActivity.this,PassCardDisplayActivity.class);
                intent.putExtra(Constant.ID,adapter.getData().get(i).getNum());
                startActivity(intent);
            }
        });
    }
}
