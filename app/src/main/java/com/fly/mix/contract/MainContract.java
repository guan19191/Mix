package com.fly.mix.contract;

import com.fly.mix.BaseApiService;
import com.fly.mix.Constants;
import com.fly.mix.base.ApiClient;
import com.fly.mix.base.BaseObserver;
import com.fly.mix.callback.BaseRequestCallback;
import com.fly.mix.base.IView;
import com.fly.mix.base.RxPresenter;
import com.fly.mix.base.RxUtil;

import io.reactivex.disposables.Disposable;

/**
 * @Author admin
 * Created on 2019/4/26 15:51.
 * Desc:Mix
 */
public interface MainContract {
    interface MainView extends IView {

    }

    class MainPresenter extends RxPresenter<MainView> implements BaseRequestCallback {
        public MainPresenter() {

        }

        @Override
        public void onStart() {
            super.onStart();

            Disposable disposable = ApiClient.getRetrofit().create(BaseApiService.class).
                    get(Constants.BASE_URL + Constants.HOME_TOP_ARTICLE).
                    compose(RxUtil.<String>rxScheduleio2Main()).subscribeWith(new BaseObserver(this) {
            });

            addDisposable(disposable);
        }


        @Override
        public void onRequestStart() {
            getView().showLoading();
        }

        @Override
        public void onRequestSuccess(String s) {

        }

        @Override
        public void onRequestError() {

        }

        @Override
        public void onRequestFailed() {

        }

        @Override
        public void onRequestComplete() {
            getView().hideLoading();
        }
    }
}
