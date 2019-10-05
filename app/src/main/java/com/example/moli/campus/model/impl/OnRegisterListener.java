package com.example.moli.campus.model.impl;

/**
 * Created by moli on 2019/10/4
 * 功能：注册状态监听接口
 * 注意!!! 在UserPresenter中实现
 */

public interface OnRegisterListener {

    //注册成功
    void regSuccess(String json);

    //注册失败
    void regFailed(String json);
}
