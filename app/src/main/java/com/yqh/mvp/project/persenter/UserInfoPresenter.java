package com.yqh.mvp.project.persenter;

import com.yqh.mvp.library.base.BasePresenter;
import com.yqh.mvp.project.contract.UserContract;
import com.yqh.mvp.project.model.UserModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class UserInfoPresenter extends BasePresenter<UserContract.UserView,UserModel> implements UserContract.UserPresenter {

    public UserInfoPresenter() {

    }

    @Override
    public void getUserInfo(String userName) {
        //todo ===== 模拟请求数据(在model 层创建数据请求的 Call 请求，在 presenter 进行 提交请求)
        getModel().getUserInfo(userName).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                if(getView() == null) return;

            }

            @Override
            public void onNext(@NonNull String s) {
                if(getView() == null) return;

                getView().setUserInfo(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                if(getView() == null) return;

            }

            @Override
            public void onComplete() {
                if(getView() == null) return;

            }
        });

    }
}
