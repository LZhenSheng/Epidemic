package com.example.epidemic.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTimeActivity;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

public class LoginStudengActivity extends BaseTimeActivity {

    /***
     * ButterKnife绑定
     */
    @BindView(R.id.l_register)
    TextView lRegister;

    @BindView(R.id.l_account)
    EditText lAccount;

    @BindView(R.id.l_password)
    EditText lPassword;

    @BindView(R.id.l_forget)
    TextView lForget;

    @BindView(R.id.l_login)
    Button lLogin;

    /***
     * 为各控件注册点击事件
     * @param view
     */
    @OnClick({R.id.l_register, R.id.l_forget, R.id.l_login,R.id.iv_replace})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.l_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.l_forget:
                startActivity(ForgetPasswordActivity.class);
                break;
            case R.id.l_login:
                startActivityAfterFinishThis(MainActivity.class);
                break;
            case R.id.iv_replace:
                startActivityAfterFinishThis(LoginTeacherActivity.class);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_studeng);
    }



    @Override
    public void initData() {
        super.initData();
        lightStatusBar(R.color.location_login);
    }

    @Override
    protected void initViews() {
        super.initViews();

    }



}