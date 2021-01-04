package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.liteorm.PassCard;
import com.example.epidemic.util.LiteORMUtil;

import butterknife.BindView;

public class PassCardDisplayActivity extends BaseTitleActivity {

    @BindView(R.id.et_nickname)
    TextView et_nickname;

    @BindView(R.id.num)
    TextView num;

    @BindView(R.id.start_date)
    TextView start_date;

    @BindView(R.id.end_date)
    TextView end_date;

    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.reason)
    TextView reason;

    String id;

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_card_display);
    }

    @Override
    protected void initViews() {
        super.initViews();
        id=extraId();
        orm = LiteORMUtil.getInstance(getApplicationContext());
        PassCard passCard=orm.queryPassCard(id);
        et_nickname.setText(passCard.getNname().trim());
        num.setText(passCard.getNum().trim());
        start_date.setText(passCard.getStartDate().trim());
        end_date.setText(passCard.getEndDate().trim());
        status.setText(passCard.getStatus().trim());
        reason.setText(passCard.getReason().trim());
    }
}
