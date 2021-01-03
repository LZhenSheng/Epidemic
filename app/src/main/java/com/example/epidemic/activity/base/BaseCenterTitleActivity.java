package com.example.epidemic.activity.base;

import android.widget.TextView;

import com.example.epidemic.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 通用标题界面
 */
public class BaseCenterTitleActivity extends BaseActivity {


    @OnClick(R.id.home)
    public void onHome(){
        finish();
    }

    @BindView(R.id.title)
    TextView title;

    @Override
    protected void initViews() {
        super.initViews();
        lightStatusBar(R.color.main_color);

    }

    public void setTitle(String content){
        title.setText(content);
    }
}
