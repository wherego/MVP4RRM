package com.pyz.retrofitdemo.net;

import com.pyz.retrofitdemo.bean.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Company: 深圳君南信息系统有限公司
 * @Date: 2016/9/1 17:47
 */
public interface NetRequest {
    @GET("/heweather/weather/free?/")
    Call<WeatherInfo> getWeather(@Header("apiKey")String apiKey, @Query("city")String city);

    @GET("/heweather/weather/free?/")
    Observable<WeatherInfo> getWeatherByRxJava(@Header("apiKey")String apiKey, @Query("city")String city);
}
