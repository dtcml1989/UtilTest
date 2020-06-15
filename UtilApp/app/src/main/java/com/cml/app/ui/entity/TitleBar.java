package com.cml.app.ui.entity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cml.app.R;

public class TitleBar {
    private View mRoot;
    private TextView mTitleView;
    private ImageView mLeftImageView;
    private TextView mLeftTextView;
    private LinearLayout mLeftLayout;
    private TextView mRightTextView;
    private ImageView mRightImageView;
    private LinearLayout mRightLayout;

    public TitleBar(View root) {
        mRoot = root;
        mTitleView = mRoot.findViewById(R.id.title);
        mLeftImageView = mRoot.findViewById(R.id.left_image);
        mLeftTextView = mRoot.findViewById(R.id.left_text);
        mLeftLayout = mRoot.findViewById(R.id.left_layout);
        mRightImageView = mRoot.findViewById(R.id.right_image);
        mRightTextView = mRoot.findViewById(R.id.right_text);
        mRightLayout = mRoot.findViewById(R.id.right_layout);

        mTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        reset();
    }

    /**
     *隐藏titlebar中的所有控件
     */
    public void reset() {
        mLeftImageView.setVisibility(View.GONE);
        mLeftTextView.setVisibility(View.GONE);
        mRightImageView.setVisibility(View.GONE);
        mRightTextView.setVisibility(View.GONE);

        mRightLayout.setOnClickListener(null);
        mLeftLayout.setOnClickListener(null);

        mTitleView.setTextColor(Color.parseColor("#000000"));
        mLeftTextView.setTextColor(Color.parseColor("#6D6D6D"));
        mRightTextView.setTextColor(Color.parseColor("#6D6D6D"));
        mRoot.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    /**
     * 设置titlebar的背景色
     * @param color, color res id
     */
    public void setTitleBarBackground(int color) {
        mRoot.setBackgroundColor(color);
    }


    /**
     * 设置titlebar的背景色
     * @param drawable
     */
    public void setTitleBarBackground(Drawable drawable) {
        mRoot.setBackground(drawable);
    }

    /**
     * 设置titilebar 标题
     * @param text
     */
    public void setTitleText(String text) {
        mTitleView.setText(text);
    }

    /**
     * titilebar 右边图标是否显示
     * @param show
     */
    public void showRightImageView(boolean show) {
        mRightImageView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /**
     * titlebar右图标旁的文本是否显示
     * @param show
     */
    public void showRightTextView(boolean show) {
        mRightTextView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置titlebar标题字体颜色
     * @param color
     */
    public void setTitleTextColor(int color) {
        mTitleView.setTextColor(color);
    }

    /**
     * 设置titlebar右边文本的颜色
     * @param color
     */
    public void setRightTextColor(int color) {
        mRightTextView.setTextColor(color);
    }

    /**
     * 设置titlebar右边图标
     * @param res, res id
     */
    public void setRightImageResource(int res) {
        mRightImageView.setImageResource(res);
    }

    /**
     * 设置titlebar右边图标文本
     * @param text
     */
    public void setRightText(String text) {
        mRightTextView.setText(text);
    }

    /**
     * 设置titilbar右边控件(图标+文本)的监听事件
     * @param l
     */
    public void setRightClickListener(View.OnClickListener l) {
        mRightLayout.setOnClickListener(l);
    }

    /**
     * 设置titlebar左图标
     * @param res, res id
     */
    public void setLeftImageResource(int res) {
        mLeftImageView.setImageResource(res);
    }


    /**
     * titilebar左边文本是否显示
     * @param show
     */
    public void showLeftTextView(boolean show) {
        mLeftTextView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /***********************************设置titlebar文本与图片相对位置************************************/

    public void setLeftCompoundDrawablesRelativeWithIntrinsicBounds(int left, int top, int right, int bottom) {
        mLeftTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    }

    public void setLeftCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        mLeftTextView.setCompoundDrawables(left, top, right, bottom);
    }

    public void setLeftCompoundDrawablePadding(int padding) {
        mLeftTextView.setCompoundDrawablePadding(padding);
    }

    public void setRightCompoundDrawablesRelativeWithIntrinsicBounds(int left, int top, int right, int bottom) {
        mRightTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    }

    public void setRightCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        mRightTextView.setCompoundDrawables(left, top, right, bottom);
    }

    public void setRightCompoundDrawablePadding(int padding) {
        mRightTextView.setCompoundDrawablePadding(padding);
    }

    public void setRightLayoutMargins(int left, int top, int right, int bottom) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mRightLayout.getLayoutParams());

        layoutParams.leftMargin   = left > 0   ? left   : layoutParams.leftMargin;
        layoutParams.topMargin    = top > 0    ? top    : layoutParams.topMargin;
        layoutParams.rightMargin  = right > 0  ? right  : layoutParams.rightMargin;
        layoutParams.bottomMargin = bottom > 0 ? bottom : layoutParams.bottomMargin;
        layoutParams.gravity = Gravity.CENTER_VERTICAL|Gravity.END;

        mRightLayout.setLayoutParams(layoutParams);
    }

    public void setLeftText(String text) {
        mLeftTextView.setText(text);
    }

    public void setLeftLayoutMargins(int left, int top, int right, int bottom) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mLeftLayout.getLayoutParams());

        layoutParams.leftMargin   = left > 0   ? left   : layoutParams.leftMargin;
        layoutParams.topMargin    = top > 0    ? top    : layoutParams.topMargin;
        layoutParams.rightMargin  = right > 0  ? right  : layoutParams.rightMargin;
        layoutParams.bottomMargin = bottom > 0 ? bottom : layoutParams.bottomMargin;
        layoutParams.gravity = Gravity.CENTER_VERTICAL;

        mLeftLayout.setLayoutParams(layoutParams);
    }

    public void showLeftImageView(boolean show) {
        mLeftImageView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setLeftClickListener(View.OnClickListener l) {
        mLeftLayout.setOnClickListener(l);
    }

    public void setTitleCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        mTitleView.setCompoundDrawables(left, top, right, bottom);
    }

    public void setTitleCompoundDrawablePadding(int padding) {
        mTitleView.setCompoundDrawablePadding(padding);
    }

    public void setTitleClickListener(View.OnClickListener l) {
        mTitleView.setOnClickListener(l);
    }
}
