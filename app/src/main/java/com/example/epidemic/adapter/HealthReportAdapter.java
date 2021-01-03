package com.example.epidemic.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.epidemic.R;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.util.TimeUtil;

/**
 *
 */
public class HealthReportAdapter extends BaseQuickAdapter<HealthReport, BaseViewHolder> {

    /**
     * 构造方法
     *
     * @param layoutResId 布局Id
     */
    public HealthReportAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 显示数据
     *
     * @param helper
     * @param data
     */
    @Override
    protected void convert(@NonNull BaseViewHolder helper, HealthReport data) {
        helper.setText(R.id.time, TimeUtil.commonFormat(data.getDate()));
        helper.setText(R.id.temperature, data.getTemperature()+"℃");
        helper.setText(R.id.status,"健康");
    }

}