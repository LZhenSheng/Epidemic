package com.example.epidemic.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class TestAdapter extends PagerAdapter {

    private ArrayList<View> mLists;
    //构造方法，传入ArrayList<view>
    public TestAdapter(ArrayList<View> mLists){
        this.mLists = mLists;
    }
    //获取当前List大小
    @Override
    public int getCount(){
        return mLists.size();
    }
    //往容器中添加list中的View
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mLists.get(position));
        return mLists.get(position);
    }
    //移除容器中的View Item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mLists.get(position));
    }

    @Override
    public boolean isViewFromObject(View view,Object object){
        return view==object;
    }
}