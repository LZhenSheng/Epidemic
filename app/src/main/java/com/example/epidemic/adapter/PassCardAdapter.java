package com.example.epidemic.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.epidemic.R;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.liteorm.PassCard;
import com.example.epidemic.util.TimeUtil;

public class PassCardAdapter extends BaseQuickAdapter<PassCard, BaseViewHolder> {
    /**
     * 构造方法
     *
     * @param layoutResId 布局Id
     */
    public PassCardAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 显示数据
     *
     * @param helper
     * @param data
     */
    @Override
    protected void convert(@NonNull BaseViewHolder helper, PassCard data) {
        helper.setText(R.id.status, data.getStatus());
        helper.setText(R.id.commit_date,"申请日期:"+TimeUtil.commonFormat(data.getCommitDate()));
        helper.setText(R.id.apply_name,"申请人:"+data.getNname());
    }

}