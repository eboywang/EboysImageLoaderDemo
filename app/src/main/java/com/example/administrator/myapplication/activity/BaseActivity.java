package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 文件作用描述
 *
 * @author [你的名字（中文全称）] 2015-06-18 15:28
 * @version 1.0.0
 */

public abstract class  BaseActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initDatas();
        initViews();
        initListeners();
    }
    protected abstract int getContentView();
    protected abstract void initDatas();
    protected abstract void initViews();
    protected abstract void initListeners();




}
