package com.example.moli.campus.model.impl;

/**
 * Created by moli on 2019/10/4.
 * 功能：user的登录注册逻辑接口，在UserModel中实现
 */

public interface IUserModel {
    //登录
    public void login(String username, String password, OnLoginListener loginListener);
    //注册
    public void register(String username, String password, OnRegisterListener registerListener);
}
