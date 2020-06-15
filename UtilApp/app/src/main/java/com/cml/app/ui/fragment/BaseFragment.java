package com.cml.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cml.app.ui.activity.BaseActivity;
import com.cml.app.ui.entity.TitleBar;

public abstract class BaseFragment extends Fragment {

    protected BaseActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (BaseActivity) getActivity();
    }

    /**
     * 设置根布局
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView(View root);

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 设置TitleBar
     * @param HRTitleBar
     */
    public abstract void setTitleBar(TitleBar HRTitleBar);
}
