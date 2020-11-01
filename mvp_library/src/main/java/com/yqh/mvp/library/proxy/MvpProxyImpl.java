package com.yqh.mvp.library.proxy;

import com.yqh.mvp.library.base.BasePresenter;
import com.yqh.mvp.library.base.IBaseView;
import com.yqh.mvp.library.inject.InjectPresenter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MvpProxyImpl<V extends IBaseView> implements IMvpProxy {
    private V mView;
    private List<BasePresenter> presenters;

    public MvpProxyImpl(V mView) {
        this.mView = mView;
        presenters = new ArrayList<BasePresenter>();
    }

    @Override
    public void bindAndCreatePresenter() {
        injectPresenter();
    }

    @Override
    public void unBindPresenter() {
        for (BasePresenter presenter : presenters) {
            presenter.detach();
        }
        presenters.clear();
        presenters = null;
    }

    private void injectPresenter() {
        try {
            Field[] fields = mView.getClass().getDeclaredFields();
            if (fields == null || fields.length == 0) return;
            for (Field field : fields) {
                field.setAccessible(true);
                Annotation fieldAnnotation = field.getAnnotation(InjectPresenter.class);
                if (fieldAnnotation == null) continue;

                Class<? extends BasePresenter> presenterClass;

                presenterClass = (Class<? extends BasePresenter>) field.getType();
                BasePresenter presenter = presenterClass.newInstance();
                field.set(mView,presenter);
                presenter.attach(mView);
                presenters.add(presenter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
