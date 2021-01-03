package com.example.epidemic.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTimeActivity;
import com.example.epidemic.util.LiteORMUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseTimeActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.r_account)
    EditText account;

    @BindView(R.id.r_password1)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void initData() {
        super.initData();
        lightStatusBar(R.color.location_login);
    }

    @OnClick(R.id.r_login)
    public void onClick(){
        orm.createAccount(account.getText().toString().trim(),password.getText().toString().trim());
    }

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getApplicationContext());
    }
}
