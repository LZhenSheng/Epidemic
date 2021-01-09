package com.example.epidemic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.epidemic.R;
import com.example.epidemic.activity.ApplicationForReturningToSchoolActivity;
import com.example.epidemic.activity.ApplyForPassActivity;
import com.example.epidemic.activity.BindingInformationActivity;
import com.example.epidemic.activity.CodeActivity;
import com.example.epidemic.activity.FootprintActivity;
import com.example.epidemic.activity.HealthReportHistoryActivity;
import com.example.epidemic.activity.LeaveApplicationActivity;
import com.example.epidemic.activity.LoginStudengActivity;
import com.example.epidemic.activity.QuestionReportActivity;
import com.example.epidemic.activity.UserMessageActivity;
import com.example.epidemic.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseCommonFragment {

    @BindView(R.id.apply_code)
    LinearLayout apply_code;

    @BindView(R.id.apply_pass_check)
    LinearLayout apply_pass_check;

    @BindView(R.id.avator)
    ImageView avatar;

    /**
     * 构造方法
     *
     * 固定写法
     *
     * @return
     */
    public static MeFragment newInstance() {
        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /***
     * 获取View
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me,container,false);
    }


//    @OnClick({ R.id.generate_codeing})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.generate_codeing:
//                startActivity(new Intent(getActivity(), CodeActivity.class));
//                break;
//        }
//    }


    @Override
    protected void initViews() {
        super.initViews();
        if(PreferenceUtil.getType().equals("1")){
            apply_code.setVisibility(View.GONE);
        }else{
            apply_pass_check.setVisibility(View.GONE);
        }
        Glide.with(getMainActivity()).load("http://bmob-cdn-28709.bmobpay.com/2020/09/27/eebf2bf6d3aa4e29aafb5f521b33423a.jpg").into(avatar);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @OnClick({R.id.footprint,R.id.apply_leave,R.id.returning_school,R.id.binding_information,R.id.exit,R.id.user_message,R.id.health_report,R.id.apply_pass_check,R.id.question_report,R.id.apply_code})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.exit:
                PreferenceUtil.setSession(false);
                startActivityAfterFinishThis(LoginStudengActivity.class);
                 break;
            case R.id.user_message:
                startActivity(UserMessageActivity.class);
                break;
            case R.id.health_report:
                startActivity(HealthReportHistoryActivity.class);
                break;
            case R.id.apply_pass_check:
                startActivity(ApplyForPassActivity.class);
                break;
            case R.id.question_report:
                startActivity(QuestionReportActivity.class);
                break;
            case R.id.apply_code:
                startActivity(CodeActivity.class);
                break;
            case R.id.binding_information:
                startActivity(BindingInformationActivity.class);
                break;
            case R.id.returning_school:
                startActivity(ApplicationForReturningToSchoolActivity.class);
                break;
            case R.id.apply_leave:
                startActivity(LeaveApplicationActivity.class);
                break;
            case R.id.footprint:
                startActivity(FootprintActivity.class);
                break;
        }
    }
}
