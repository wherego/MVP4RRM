package com.pyz.retrofitdemo.mvp;

/**
 * @Author: pyz
 * @Package: com.pyz.retrofitdemo.mvp
 * @Description: TODO
 * @Project: Retrofit-RxJavaDemo
 * @Company: 深圳君南信息系统有限公司
 * @Date: 2016/9/1 17:31
 */
public interface MVPRequestCallBack<T> {
    /**
     * 开始请求之前
     */
    void requestBefore();

    /**
     * 请求失败
     *
     */
    void requestError(Throwable e);

    /**
     * 请求结束
     */
    void requestComplete();

    /**
     * 请求成功
     *
     * @param callBack 根据业务返回相应的数据
     */
    void requestSuccess(T callBack);
}
