package com.pyz.retrofitdemo.mvp;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.mvp
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 17:29
 */
public interface MVPPresenter {

//     用于做一些初始化的操作
    void onResume();

//    用于做一些销毁、回收等类型的操作
    void onDestroy();
}
