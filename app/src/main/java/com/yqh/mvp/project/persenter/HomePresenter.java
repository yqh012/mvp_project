package com.yqh.mvp.project.persenter;

import com.yqh.mvp.library.base.BasePresenter;
import com.yqh.mvp.project.contract.HomeContract;
import com.yqh.mvp.project.model.HomeModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class HomePresenter extends BasePresenter<HomeContract.HomeView, HomeModel> implements HomeContract.HomePresenter {
    @Override
    public void initHomeInfo() {
        getModel().getHomeInfo().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                getView().setHomeInfo(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
