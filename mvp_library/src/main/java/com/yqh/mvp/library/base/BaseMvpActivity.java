package com.yqh.mvp.library.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yqh.mvp.library.proxy.ActivityMvpProxy;
import com.yqh.mvp.library.proxy.ActivityMvpProxyImpl;


public abstract class BaseMvpActivity extends AppCompatActivity implements IBaseView {

    private ActivityMvpProxy activityProxy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        createActivityProxy();

        activityProxy.bindAndCreatePresenter();
        
        getView();

        getData();
    }

    protected abstract int getContentView();

    protected abstract void getView();

    protected abstract void getData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityProxy.unBindPresenter();
    }

    private void createActivityProxy() {
        if(activityProxy == null) {
            activityProxy = new ActivityMvpProxyImpl<>(this);
        }
    }

}
