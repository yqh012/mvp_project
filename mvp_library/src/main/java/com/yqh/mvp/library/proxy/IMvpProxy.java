package com.yqh.mvp.library.proxy;

public interface IMvpProxy {
    /**
     * 绑定
     */
    void bindAndCreatePresenter();

    /**
     * 解绑
     */
    void unBindPresenter();
}
