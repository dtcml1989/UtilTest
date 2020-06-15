package com.cml.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.cml.app.R;
import com.cml.app.utils.WeakHandler;

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();
    protected BaseActivity mContext;

    protected WeakHandler mHandler = new WeakHandler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            handlerMsg(msg);
            return false;
        }
    });

    private AlertDialog mDialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext = this;
    }

    private void initLoading() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        mDialogLoading = builder.create();
        mDialogLoading.setCanceledOnTouchOutside(false);
    }

    public void showLoading() {
        if(mDialogLoading != null && !mDialogLoading.isShowing()) {
            mDialogLoading.show();
            View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_progress, null);
            mDialogLoading.setContentView(view);
            mDialogLoading.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            mDialogLoading.getWindow().getDecorView().setBackgroundColor(0x00000000);
            mDialogLoading.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        }
    }

    public void hideLoading() {
        if(mDialogLoading != null && mDialogLoading.isShowing()) {
            mDialogLoading.dismiss();
        }
    }

    public WeakHandler getHandler() {
        return mHandler;
    }


    /**
     * 设置根布局
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 处理handler消息
     */
    public void handlerMsg(Message msg) {};

}
