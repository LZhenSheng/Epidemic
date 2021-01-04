package com.example.epidemic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.epidemic.R;
import com.example.epidemic.activity.base.BaseTitleActivity;
import com.example.epidemic.liteorm.PassCard;
import com.example.epidemic.util.DateUtil;
import com.example.epidemic.util.LiteORMUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class AddApplyForPassActivity extends BaseTitleActivity {

    /**
     * 数据库框架
     */
    private LiteORMUtil orm;

    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.student_num)
    EditText student_num;

    @BindView(R.id.reason)
    EditText reason;

    @BindView(R.id.start_date_display)
    TextView start_date_display;

    @BindView(R.id.end_date_display)
    TextView end_date_display;

    TimePickerView pvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apply_for_pass);
    }

    @OnClick({R.id.start_date, R.id.end_date,R.id.commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_date:
                detail1();
                break;
            case R.id.end_date:
                detail2();
                break;
            case R.id.commit:
                PassCard passCard=new PassCard();
                passCard.setNname(name.getText().toString().trim());
                passCard.setCommitDate(DateUtil.getDate());
                passCard.setReason(reason.getText().toString().trim());
                passCard.setNum(student_num.getText().toString());
                passCard.setStartDate(start_date_display.getText().toString().trim());
                passCard.setEndDate(end_date_display.getText().toString().trim());
                orm.createPassCard(passCard);
                break;
        }
    }

    private void detail1() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2040, 11, 31);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView tv = (TextView) v;
                tv.setText(getTimes(date));
            }
        })
                //年月日时分秒的显示与否，不设置则默认全部显示，这里可自行定制
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel(" 年", "月", "日", "时", "分", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();
        pvTime.show(start_date_display);
    }

    private void detail2() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, 0, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2040, 11, 31);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView tv = (TextView) v;
                tv.setText(getTimes(date));
            }
        })
                //年月日时分秒的显示与否，不设置则默认全部显示，这里可自行定制
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel(" 年", "月", "日", "时", "分", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();
        pvTime.show(end_date_display);
    }

    private String getTimes(Date date) {//可根据需要自行格式化数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    @Override
    protected void initViews() {
        super.initViews();
        orm = LiteORMUtil.getInstance(getApplicationContext());
    }
}
