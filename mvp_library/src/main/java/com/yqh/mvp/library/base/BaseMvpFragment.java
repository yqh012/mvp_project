package com.yqh.mvp.library.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yqh.mvp.library.proxy.FragmentMvpProxyImpl;


public abstract class BaseMvpFragment extends Fragment implements IBaseView {

    private FragmentMvpProxyImpl proxy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createProxy();
        proxy.bindAndCreatePresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(proxy != null)
            proxy.unBindPresenter();
    }

    private void createProxy(){
        if(proxy == null)
            proxy = new FragmentMvpProxyImpl(this);
    }

    protected abstract int getLayout();

    protected abstract void initView(View view);

    protected abstract void initData();

}
