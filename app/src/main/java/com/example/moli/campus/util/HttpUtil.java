package com.example.moli.campus.util;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by moli on 2019/10/4.
 * 功能：网络请求
 */


public class HttpUtil {

    private static OkHttpClient okHttpClient;
    //同步处理
    private static OkHttpClient getOkHttpClient() {
        synchronized (HttpUtil.class) {
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
        }
        return okHttpClient;
    }
    //get请求
    public static void doGet(String url, Callback callbak) {
        //创建OKhttpclient对象
        OkHttpClient okHttpClient = getOkHttpClient();
        //创建请求队列
        Request build = new Request.Builder().url(url).build();
        //开始请求
        okHttpClient.newCall(build).enqueue(callbak);
    }
    //post请求
    public static void doPost(String url, Map<String, String> map, Callback callback) {
        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        //便利map集合,设置请求体
        for (String keys : map.keySet()) {
            builder.add(keys, map.get(keys));
        }
        //设置请求的方式
        Request build = new Request.Builder().url(url).post(builder.build()).build();
        //开始请求
        okHttpClient.newCall(build).enqueue(callback);
    }
}
