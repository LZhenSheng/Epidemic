package com.example.epidemic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseActivity;
import com.example.epidemic.adapter.MainAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.indicator_iv1)
    ImageView indicator_iv1;
    @BindView(R.id.indicator_iv2)
    ImageView indicator_iv2;
    @BindView(R.id.indicator_iv3)
    ImageView indicator_iv3;
    @BindView(R.id.indicator_iv4)
    ImageView indicator_iv4;

    @OnClick({R.id.indicator_iv1,R.id.indicator_iv2,R.id.indicator_iv3,R.id.indicator_iv4})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.indicator_iv1:
                clearBackground();
                indicator_iv1.setImageResource(R.mipmap.home_selected);
                vp.setCurrentItem(0);
                break;
            case R.id.indicator_iv2:
                clearBackground();
                indicator_iv2.setImageResource(R.mipmap.discovery_selected);
                vp.setCurrentItem(1);
                break;
            case R.id.indicator_iv3:
                clearBackground();
                indicator_iv3.setImageResource(R.mipmap.healthy_selected);
                vp.setCurrentItem(2);
                break;
            case R.id.indicator_iv4:
                clearBackground();
                indicator_iv4.setImageResource(R.mipmap.my_selected);
                vp.setCurrentItem(3);
                break;
        }
    }

    private void clearBackground() {
        indicator_iv1.setImageResource(R.mipmap.home);
        indicator_iv2.setImageResource(R.mipmap.discovery);
        indicator_iv3.setImageResource(R.mipmap.healthy);
        indicator_iv4.setImageResource(R.mipmap.my);
    }

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void initData() {
        super.initData();

        //缓存页面数量 默认是缓存一个
        vp.setOffscreenPageLimit(4);

        //主界面页面MainAda
        adapter = new MainAdapter(getMainActivity(), getSupportFragmentManager());
        vp.setAdapter(adapter);

        ArrayList<Integer> datas = new ArrayList<>();
        datas.add(0);
        datas.add(1);
        datas.add(2);
        datas.add(3);
        adapter.setDatum(datas);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                clearBackground();
                switch (position){
                    case 0:
                        indicator_iv1.setImageResource(R.mipmap.home_selected);
                        break;
                    case 1:
                        indicator_iv2.setImageResource(R.mipmap.discovery_selected);
                        break;
                    case 2:
                        indicator_iv3.setImageResource(R.mipmap.healthy_selected);
                        break;
                    case 3:
                        indicator_iv4.setImageResource(R.mipmap.my_selected);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
    }
}
