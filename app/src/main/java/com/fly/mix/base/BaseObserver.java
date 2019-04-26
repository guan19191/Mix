package com.fly.mix.base;

import com.fly.mix.callback.BaseRequestCallback;

import io.reactivex.observers.DisposableObserver;

/**
 * @Author admin
 * Created on 2019/4/25 11:56.
 * Desc:Mix
 */
public class BaseObserver extends DisposableObserver<String> {
    BaseRequestCallback callBack;

    public BaseObserver(BaseRequestCallback callBack) {
        this.callBack = callBack;
    }

    @Override
    protected void onStart() {
        super.onStart();
        callBack.onRequestStart();
    }

    @Override
    public void onNext(String s) {
        callBack.onRequestSuccess(s);
    }

    @Override
    public void onError(Throwable e) {
        callBack.onRequestError();
    }

    @Override
    public void onComplete() {
        callBack.onRequestComplete();
    }
}
