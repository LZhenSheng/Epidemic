package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;

public class LeaveApplicationActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_application);
    }
}
