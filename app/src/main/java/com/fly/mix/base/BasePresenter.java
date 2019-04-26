package com.fly.mix.base;

import com.fly.mix.presenter.IPresenter;

import java.lang.ref.WeakReference;

/**
 *
 */
public abstract class BasePresenter<V extends IView> implements IPresenter {

    private WeakReference<V> viewReference;

    public BasePresenter() {
        onStart();
    }

//    abstract void createModel();

    public void attachView(V view) {
        viewReference = new WeakReference<V>(view);
    }

    public void detachView() {
        if (viewReference != null) {
            onDestroy();
        }
    }

    public V getView() {
        return viewReference.get();
    }

    public boolean isViewAttached() {
        if (viewReference != null && viewReference.get() != null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onStart() {
        //createModel();
    }

    @Override
    public void onDestroy() {
        viewReference.clear();
        viewReference = null;
    }
}
