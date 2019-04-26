package com.fly.mix.callback;

/**
 *
 */
public interface BaseRequestCallback {

    void onRequestStart();

    void onRequestSuccess(String result);

    void onRequestError();

    void onRequestFailed();

    void onRequestComplete();
}
