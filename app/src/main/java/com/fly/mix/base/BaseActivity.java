package com.fly.mix.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fly.mix.Util.AppManager;

/**
 * @Author admin
 * Created on 2019/4/26 11:00.
 * Desc:Mix
 */
public  abstract  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);//添加到栈中
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);//从栈中移除
    }
}
