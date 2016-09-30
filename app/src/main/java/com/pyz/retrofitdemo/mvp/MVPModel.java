package com.pyz.retrofitdemo.mvp;

import com.pyz.retrofitdemo.net.RetrofitWrapper;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.mvp
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 17:38
 */
public class MVPModel {
    public RetrofitWrapper retrofitWrapper;

    public MVPModel(){
        retrofitWrapper = RetrofitWrapper.getInstance();
    }
}
