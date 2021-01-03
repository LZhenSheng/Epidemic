package com.example.epidemic.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.ToastUtil;

import butterknife.BindView;

/***
* 增加健康上报界面
* @author 胜利镇
* @time 2021/1/2
* @dec 
*/
public class AddHealthReport extends BaseTitleActivity {


    @BindView(R.id.radiobutton11)
    RadioButton radioButton11;

    @BindView(R.id.radiobutton12)
    RadioButton radioButton12;

    @BindView(R.id.radiogroup1)
    RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_report);
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    @Override
    protected void initListener() {
        super.initListener();
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==radioButton11.getId()){
                    ToastUtil.successShortToast("1");
                }else if(checkedId==radioButton12.getId()){
                    ToastUtil.successShortToast("2");
                }
            }
        });
    }
}
