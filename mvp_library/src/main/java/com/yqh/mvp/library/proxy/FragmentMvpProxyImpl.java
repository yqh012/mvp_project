package com.yqh.mvp.library.proxy;

import com.yqh.mvp.library.base.IBaseView;

public class FragmentMvpProxyImpl<V extends IBaseView> extends MvpProxyImpl<V> implements FragmentMvpProxy{

    public FragmentMvpProxyImpl(V mView) {
        super(mView);
    }

}
