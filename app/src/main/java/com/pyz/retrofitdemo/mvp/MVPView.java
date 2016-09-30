package com.pyz.retrofitdemo.mvp;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.mvp
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 17:23
 */
public interface MVPView<T> {

    void toast(String msg);


    void showProgress();


    void hideProgress();


    void onSuccess(T data);


    void onFail(Throwable e);
}
