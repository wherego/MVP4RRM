package com.pyz.retrofitdemo.view.weatherinfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jn.chart.charts.LineChart;
import com.jn.chart.data.Entry;
import com.jn.chart.manager.LineChartManager;
import com.pyz.retrofitdemo.Constant;
import com.pyz.retrofitdemo.R;
import com.pyz.retrofitdemo.bean.DailyForecast;
import com.pyz.retrofitdemo.presenter.WeatherInfoPresenter;

import java.util.ArrayList;

public class MainActivity extends Activity implements WeatherInfoView {
    private Button request;
    private LineChart chart;
    private ProgressDialog pd;

    private ArrayList<String> xValues = new ArrayList<>();
    private ArrayList<Entry> yValues2Max = new ArrayList<Entry>();
    private ArrayList<Entry> yValues2Min = new ArrayList<Entry>();

    private WeatherInfoPresenter weatherInfoPresenter;
    private int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        request = (Button) this.findViewById(R.id.request);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        chart = (LineChart) this.findViewById(R.id.weatherChart);
        weatherInfoPresenter = new WeatherInfoPresenter(this,this);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weatherInfoPresenter.getWeatherInfo(Constant.API_KEY,Constant.CITY);
            }
        });
    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {
        if (pd != null && !pd.isShowing()) {
            pd.show();
        }
    }

    @Override
    public void hideProgress() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    @Override
    public void onSuccess(DailyForecast data) {
        int j = i++;
        xValues.add(data.getDate());
        yValues2Max.add(new Entry(Float.valueOf(data.getTmp().getMaxTem()), j));
        yValues2Min.add(new Entry(Float.valueOf(data.getTmp().getMinTem()), j));

        chart.setDescription("广州气温预测");
        LineChartManager.setLineName("最高温度");
        LineChartManager.setLineName1("最低温度");
        LineChartManager.initDoubleLineChart(MainActivity.this, chart, xValues, yValues2Max, yValues2Min);
    }

    @Override
    public void onFail(Throwable e) {
    }
}
