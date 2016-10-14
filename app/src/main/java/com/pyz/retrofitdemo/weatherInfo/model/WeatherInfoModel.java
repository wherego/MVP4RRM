package com.pyz.retrofitdemo.weatherInfo.model;

import android.content.Context;

import com.pyz.retrofitdemo.net.NetRequest;
import com.pyz.retrofitdemo.bean.weatherInfoBean.DailyForecast;
import com.pyz.retrofitdemo.bean.weatherInfoBean.WeatherInfo;
import com.pyz.retrofitdemo.bean.weatherInfoBean.WeatherResult;
import com.pyz.retrofitdemo.mvp.MVPModel;
import com.pyz.retrofitdemo.mvp.MVPRequestCallBack;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by pyz on 2016/5/4.
 */
public class WeatherInfoModel extends MVPModel {
    private Context context;
    private NetRequest netRequest;

    public WeatherInfoModel(Context context) {
       this.context = context;
        netRequest = retrofitWrapper.getService();
    }

    public void loadWeatherInfo(String key, String city, final MVPRequestCallBack<DailyForecast> callBack){
        netRequest.getWeatherByRxJava(key,city)
                .subscribeOn(Schedulers.io())// 指定观察者在io线程（第一次指定观察者线程有效）
                .doOnSubscribe(new Action0() {//在启动订阅前（发送事件前）执行的方法
                    @Override
                    public void call() {
                      callBack.requestBefore();
                    }
                })
                .flatMap(new Func1<WeatherInfo, Observable<WeatherResult>>() {
                    @Override
                    public Observable<WeatherResult> call(WeatherInfo weatherInfo) {
                        return Observable.from(weatherInfo.getHeWeatherDataList());
                    }
                })
                .flatMap(new Func1<WeatherResult, Observable<DailyForecast>>() {
                    @Override
                    public Observable<DailyForecast> call(WeatherResult weatherResult) {
                        return Observable.from(weatherResult.getDaily_forecast());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//指定订阅者在主线程
                .subscribe(new Subscriber<DailyForecast>() {
                    @Override
                    public void onCompleted() {
                       callBack.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                     callBack.requestError(e);
                    }

                    @Override
                    public void onNext(DailyForecast dailyForecast) {
                      callBack.requestSuccess(dailyForecast);
                    }
                });
    }

}
