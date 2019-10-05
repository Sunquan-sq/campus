package com.example.moli.campus.view;

import com.example.moli.campus.javabean.User;

/**
 * Created by moli on 2019/10/4.
 * 功能：提供接口用来实现一些对视图处理的方法，在LoginActivity实现
 */


public interface IUserView {
    //获取用户名
    String getUserName();

    //获取密码
    String getUserPassword();

    //跳转到登录页面
    void toActivity(User user);

    //显示错误信息
    void showLoginError();

}
