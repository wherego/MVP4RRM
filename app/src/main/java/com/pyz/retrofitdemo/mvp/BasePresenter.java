package com.pyz.retrofitdemo.mvp;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.mvp
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 17:33
 */

/**
 * 代理对象的基础实现
 * @param <T> 视图接口对象(view) 具体业务各自继承自IBaseView
 * @param <V> 业务请求返回的具体对象
 */
public class BasePresenter<T extends MVPView, V> implements MVPPresenter, MVPRequestCallBack<V> {
    private MVPView mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void requestBefore() {
        mView.showProgress();
    }

    @Override
    public void requestError(Throwable e) {
        mView.onFail(e);
    }

    @Override
    public void requestComplete() {
        mView.hideProgress();
    }

    @Override
    public void requestSuccess(V callBack) {
        mView.onSuccess(callBack);
    }
}
