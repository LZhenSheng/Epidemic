package com.example.epidemic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTimeActivity;
import com.example.epidemic.liteorm.Account;
import com.example.epidemic.util.LiteORMUtil;
import com.example.epidemic.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginStudengActivity extends BaseTimeActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

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
                PreferenceUtil.setObjectId("18237056873");
                PreferenceUtil.setType("1");
//                Account account=orm.queryAccountByIphonePassword(lAccount.getText().toString().trim(),lPassword.getText().toString().trim());
//                if(account!=null){
//                    PreferenceUtil.setSession(true);
//                    PreferenceUtil.setObjectId(lAccount.getText().toString());
                    startActivityAfterFinishThis(MainActivity.class);
//                }
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
        if(PreferenceUtil.getSession()){
            startActivityAfterFinishThis(MainActivity.class);
        }
    }

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getApplicationContext());
    }


}
