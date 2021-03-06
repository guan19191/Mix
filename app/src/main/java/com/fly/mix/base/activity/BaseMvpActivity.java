package com.fly.mix.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fly.mix.base.BasePresenter;
import com.fly.mix.base.IView;
import com.fly.mix.base.activity.BaseActivity;

/**
 *
 */
public abstract class BaseMvpActivity<V extends IView, P extends BasePresenter<V>> extends BaseActivity {
    public P mPresenter;

    public abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        setContentView(getLayoutId());
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
