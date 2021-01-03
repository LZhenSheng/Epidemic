package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTimeActivity;

public class ForgetPasswordActivity extends BaseTimeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }


    @Override
    public void initData() {
        super.initData();
        lightStatusBar(R.color.location_login);
    }
}
