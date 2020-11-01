package com.yqh.mvp.library.base;

public interface IBaseView {

    void showLoading();

    void dismissLoading();

    void error();

    void showToast(String toast);
}
