package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;

import butterknife.OnClick;

public class UserMessageActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);
    }

    @OnClick(R.id.save)
    public void onClick(){
        finish();
    }
}
