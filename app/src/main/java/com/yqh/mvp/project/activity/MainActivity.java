package com.yqh.mvp.project.activity;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.yqh.mvp.library.base.BaseMvpActivity;
import com.yqh.mvp.library.inject.InjectPresenter;
import com.yqh.mvp.project.R;
import com.yqh.mvp.project.contract.UserContract;
import com.yqh.mvp.project.persenter.UserInfoPresenter;

public class MainActivity extends BaseMvpActivity implements UserContract.UserView {

    private TextView tv;

    @InjectPresenter
    private UserInfoPresenter mUserPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void getView() {
        tv = findViewById(R.id.title);

        FrameLayout mFrameLayout =findViewById(R.id.fragment_layout);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout,new MainFragment()).commit();
    }

    @Override
    protected void getData() {
        mUserPresenter.getUserInfo("你好呀");
    }

    @Override
    public void setUserInfo(String userInfo) {
        tv.setText(userInfo);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void error() {

    }

    @Override
    public void showToast(String toast) {

    }
}