package com.pyz.retrofitdemo.net;

import android.content.Context;

import com.google.gson.Gson;
import com.pyz.retrofitdemo.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 网络接口服务的包装类
 */
public class RetrofitWrapper {
    private static RetrofitWrapper instance;
    private Context mContext;
    private Retrofit retrofit;
    private NetRequest netRequest;

    public NetRequest getService(){
        return netRequest;
    }

    private RetrofitWrapper() {
        Gson gson = new Gson();
        //创建Retrofit对象
        retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                //配置转化库，默认是GSON
                .addConverterFactory(GsonConverterFactory.create(gson))
                //配置回调库，采用RxJava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        netRequest = retrofit.create(NetRequest.class);
    }

    public static RetrofitWrapper getInstance() {
        if (instance == null) {
            synchronized (RetrofitWrapper.class){
                if (instance==null){
                    instance = new RetrofitWrapper();
                }
            }
        }
        return instance;
    }


}
