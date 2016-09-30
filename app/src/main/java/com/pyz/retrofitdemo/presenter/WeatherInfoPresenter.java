package com.pyz.retrofitdemo.presenter;

import android.content.Context;

import com.pyz.retrofitdemo.bean.DailyForecast;
import com.pyz.retrofitdemo.model.WeatherInfoModel;
import com.pyz.retrofitdemo.mvp.BasePresenter;
import com.pyz.retrofitdemo.view.weatherinfo.WeatherInfoView;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.presenter
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 18:03
 */
public class WeatherInfoPresenter extends BasePresenter<WeatherInfoView,DailyForecast> {
   private WeatherInfoModel weatherInfoModel;
    private Context context;

    public WeatherInfoPresenter(WeatherInfoView mView, Context context) {
        super(mView);
        this.context = context;
        weatherInfoModel = new WeatherInfoModel(context);
    }

    public void getWeatherInfo(String key, String city){
        onResume();
        weatherInfoModel.loadWeatherInfo(key,city,this);
    }

}
