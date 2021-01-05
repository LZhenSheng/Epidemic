package com.example.epidemic.activity;

import android.os.Bundle;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;

import butterknife.OnClick;

public class QuestionReportActivity extends BaseTitleActivity {

    @OnClick(R.id.summit)
    public void onClick(){
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_report);
    }
}
