package com.yqh.mvp.project.contract;


import com.yqh.mvp.library.base.IBaseModel;
import com.yqh.mvp.library.base.IBaseView;

import io.reactivex.rxjava3.core.Observable;

public class HomeContract {

    public interface HomeView extends IBaseView {
        void setHomeInfo(String homeInfo);
    }

    public interface HomePresenter {
        void initHomeInfo();
    }

    public interface HomeModel extends IBaseModel {
        Observable<String> getHomeInfo();
    }

}
