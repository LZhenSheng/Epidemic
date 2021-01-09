package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.ToastUtil;

import butterknife.OnClick;

public class ApplicationForReturningToSchoolActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_for_returning_to_school);
    }

    @OnClick(R.id.save)
    public void onClick(){
        finish();
        ToastUtil.successShortToast("申请成功");
    }
}
