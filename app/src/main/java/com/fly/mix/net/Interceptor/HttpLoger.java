package com.fly.mix.net.Interceptor;

import android.support.annotation.NonNull;

import com.fly.mix.Util.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @Author admin
 * Created on 2018/12/10 14:54.
 * Desc:WanAndroidMvp
 */
public class HttpLoger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(@NonNull String message) {
        LogUtil.e("HttpInfo:", message);
    }
}
