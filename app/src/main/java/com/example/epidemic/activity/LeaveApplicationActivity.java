package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.util.ToastUtil;

import butterknife.OnClick;

public class LeaveApplicationActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_application);
    }

    @OnClick(R.id.save)
    public void onClick(){ finish();
        ToastUtil.successShortToast("申请成功");
    }
}
