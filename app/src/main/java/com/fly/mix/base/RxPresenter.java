package com.fly.mix.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 *
 */
public class RxPresenter<V extends IView> extends BasePresenter<V> {
    protected CompositeDisposable compositeDisposable;

    /**
     * 解绑
     */
    public void unDispose() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }

    /**
     * 绑定
     */
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        unDispose();
    }


}
