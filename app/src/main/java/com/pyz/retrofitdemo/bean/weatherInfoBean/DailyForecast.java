package com.pyz.retrofitdemo.bean.weatherInfoBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyz on 2016/5/4.
 */
public class DailyForecast {
    @SerializedName("date")
    public String date;
    @SerializedName("tmp")
    public Temperature tmp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getTmp() {
        return tmp;
    }

    public void setTmp(Temperature tmp) {
        this.tmp = tmp;
    }

    @Override
    public String toString() {
        return "date = " + date + '\''
                + ", MaxTem = " + tmp.getMaxTem()
                + ", MinTem = " + tmp.getMinTem();
    }
}
