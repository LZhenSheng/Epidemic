package com.example.epidemic.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.adapter.HealthReportAdapter;
import com.example.epidemic.liteorm.HealthReport;
import com.example.epidemic.util.DateUtil;
import com.example.epidemic.util.LiteORMUtil;
import com.example.epidemic.util.PreferenceUtil;
import com.example.epidemic.util.ToastUtil;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/***
* 增加健康上报界面
* @author 胜利镇
* @time 2021/1/2
* @dec 
*/
public class AddHealthReport extends BaseTitleActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.radiobutton11)
    RadioButton radioButton11;

    @BindView(R.id.radiobutton12)
    RadioButton radioButton12;

    @BindView(R.id.radiobutton21)
    RadioButton radioButton21;

    @BindView(R.id.radiobutton22)
    RadioButton radioButton22;

    @BindView(R.id.radiobutton31)
    RadioButton radioButton31;

    @BindView(R.id.radiobutton32)
    RadioButton radioButton32;

    @BindView(R.id.radiobutton41)
    RadioButton radioButton41;

    @BindView(R.id.radiobutton42)
    RadioButton radioButton42;

    @BindView(R.id.radiobutton51)
    RadioButton radioButton51;

    @BindView(R.id.radiobutton52)
    RadioButton radioButton52;

    @BindView(R.id.radiobutton61)
    RadioButton radioButton61;

    @BindView(R.id.radiobutton62)
    RadioButton radioButton62;

    @BindView(R.id.tempory)
    EditText temperature;

    @OnClick(R.id.commit)
    public void onClick(){
        HealthReport healthReport=new HealthReport();
        healthReport.setObjectId(PreferenceUtil.getObjectId());
        healthReport.setTemperature(temperature.getText().toString().trim());
        if(radioButton11.isChecked())
            healthReport.setOption1("1");
        else
            healthReport.setOption1("2");
        if(radioButton21.isChecked())
            healthReport.setOption2("1");
        else
            healthReport.setOption2("2");
        if(radioButton31.isChecked())
            healthReport.setOption3("1");
        else
            healthReport.setOption3("2");
        if(radioButton41.isChecked())
            healthReport.setOption4("1");
        else
            healthReport.setOption4("2");
        if(radioButton51.isChecked())
            healthReport.setOption5("1");
        else
            healthReport.setOption5("2");
        if(radioButton61.isChecked())
            healthReport.setOption6("1");
        else
            healthReport.setOption6("2");
        healthReport.setDate(DateUtil.getDate());
        orm.createHealthReport(healthReport);
        finish();
        ToastUtil.successShortToast("提交成功");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_report);
    }

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getApplicationContext());
    }

    @Override
    protected void initListener() {
        super.initListener();
    }
}
