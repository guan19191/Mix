package com.fly.mix.base.fragment;

import android.content.Context;

import com.fly.mix.base.BasePresenter;
import com.fly.mix.base.IView;

/**
 * @Author admin
 * Created on 2019/4/28 11:36.
 * Desc:Mix
 */
public abstract class BaseMvpFragment<V extends IView, P extends BasePresenter<V>> extends BaseFragment {
    public P mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }


    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
    }
}
