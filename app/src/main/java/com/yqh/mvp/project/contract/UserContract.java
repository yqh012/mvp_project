package com.yqh.mvp.project.contract;

import com.yqh.mvp.library.base.IBaseModel;
import com.yqh.mvp.library.base.IBaseView;

import io.reactivex.rxjava3.core.Observable;

/**
 * mvp 功能协议类
 */
public class UserContract {

    public interface UserView extends IBaseView {
        void setUserInfo(String userInfo);
    }

    public interface UserPresenter{
        void getUserInfo(String userName);
    }

    public interface UserInfoModel extends IBaseModel {
        Observable<String> getUserInfo(String userName);
    }

}
