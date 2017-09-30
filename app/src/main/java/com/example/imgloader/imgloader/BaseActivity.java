package com.example.imgloader.imgloader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.imgloader.imgloader.utils.StatusBarUtil;

/**
 * Created by li on 2017/9/12.
 */

public class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mContext = this;
    }

    protected void setStatusBarTranslucent(boolean isLightStatusBar) {
        StatusBarUtil.setStatusBarTranslucent(this, isLightStatusBar);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if (intent == null) return;
        if (intent.getComponent() == null) return;
        String className = intent.getComponent().getClassName();
        if (!className.equals(MainActivity.class.getName())) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if (intent == null) return;
        if (intent.getComponent() == null) return;
        String className = intent.getComponent().getClassName();
        if (!className.equals(MainActivity.class.getName())) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (!((Object) this).getClass().equals(MainActivity.class)) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
