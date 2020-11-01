package com.yqh.mvp.library.proxy;


import com.yqh.mvp.library.base.IBaseView;

public class ActivityMvpProxyImpl<V extends IBaseView> extends MvpProxyImpl<V> implements ActivityMvpProxy {
    public ActivityMvpProxyImpl(V mView) {
        super(mView);
    }

    //todo == 如果有特殊处理在此处添加
}
