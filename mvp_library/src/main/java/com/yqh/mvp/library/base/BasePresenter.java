package com.yqh.mvp.library.base;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public abstract class BasePresenter<V extends IBaseView,M extends IBaseModel> {
    private final String Tag = BasePresenter.class.getSimpleName();

    private SoftReference<V> mViewReference;
    private V proxyView;
    private M mModel;

    public void attach(V view){
        this.mViewReference = new SoftReference<>(view);
        this.proxyView = (V) proxyView(view);
        this.mModel = createModel();
    }

    public void detach(){
        this.mViewReference.clear();
        this.mModel = null;
    }

    protected V getView(){
        return proxyView;
    }

    protected M getModel(){
        return this.mModel;
    }

    private Object proxyView(V view){
        return Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(mViewReference == null || mViewReference.get() == null) {
                    return null;
                }
                return method.invoke(mViewReference.get(),args);
            }
        });
    }

    private M createModel() {
        try {
            Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
            this.mModel = (M) ((Class) types[1]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.mModel;
    }

}
