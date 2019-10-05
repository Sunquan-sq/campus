package com.example.moli.campus.model.impl;

import com.example.moli.campus.javabean.User;

/**
 * Created by moli on 2019/10/4.
 * 功能：登录状态监听接口
 * 注意!!! 在UserPresenter中实现
 */

public interface OnLoginListener {

    //登录成功
    void loginSuccess(User user);

    //登录失败
    void loginFailed();

}
