package com.yqh.mvp.project.model;

import android.os.SystemClock;

import androidx.lifecycle.ViewModelProvider;

import com.yqh.mvp.project.contract.HomeContract;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeModel implements HomeContract.HomeModel {

    @Override
    public Observable<String> getHomeInfo() {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Throwable {
                SystemClock.sleep(3000);
                return "this is HomeInfo...";
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
