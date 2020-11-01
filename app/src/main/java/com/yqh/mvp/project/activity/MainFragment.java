package com.yqh.mvp.project.activity;

import android.view.View;
import android.widget.TextView;

import com.yqh.mvp.library.base.BaseMvpFragment;
import com.yqh.mvp.library.inject.InjectPresenter;
import com.yqh.mvp.project.R;
import com.yqh.mvp.project.contract.HomeContract;
import com.yqh.mvp.project.persenter.HomePresenter;

public class MainFragment extends BaseMvpFragment implements HomeContract.HomeView {

    private TextView title;

    @InjectPresenter
    private HomePresenter homePresenter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        title = view.findViewById(R.id.title);
    }

    @Override
    protected void initData() {
        homePresenter.initHomeInfo();
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

    @Override
    public void setHomeInfo(String homeInfo) {
        title.setText(homeInfo);
    }
}
