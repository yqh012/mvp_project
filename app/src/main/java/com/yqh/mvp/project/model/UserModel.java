package com.yqh.mvp.project.model;

import android.os.SystemClock;

import com.yqh.mvp.project.contract.UserContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserModel implements UserContract.UserInfoModel {

    @Override
    public Observable<String> getUserInfo(String userName) {
        return Observable.just(userName).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Throwable {
                SystemClock.sleep(3000);
                return s + " : yqh";
            }
        }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());

    }
}
