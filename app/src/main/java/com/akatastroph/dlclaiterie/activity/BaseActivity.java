package com.akatastroph.dlclaiterie.activity;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Genfinternet on 20/11/2016.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
