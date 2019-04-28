package com.fly.mix;

import com.fly.mix.base.activity.BaseMvpActivity;
import com.fly.mix.contract.MainContract;
import com.fly.mix.contract.MainContract.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainContract.MainView, MainPresenter> implements MainContract.MainView {


    @Override
    public MainPresenter createPresenter() {
        return  new MainPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
