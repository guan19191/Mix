package com.fly.mix.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @Author admin
 * Created on 2019/4/26 10:59.
 * Desc:Mix
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
            mPresenter.onDestroy();
        }
    }
}
