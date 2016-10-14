package com.pyz.retrofitdemo.weatherInfo.view;

import com.pyz.retrofitdemo.bean.weatherInfoBean.DailyForecast;
import com.pyz.retrofitdemo.mvp.MVPView;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.view.weatherinfo
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Date: 2016/9/1 17:43
 */
public interface WeatherInfoView extends MVPView<DailyForecast> {
	void showChart();
}
