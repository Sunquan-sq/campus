package com.example.moli.campus.model;

import com.example.moli.campus.config.Urls;
import com.example.moli.campus.javabean.User;
import com.example.moli.campus.model.impl.IUserModel;
import com.example.moli.campus.model.impl.OnLoginListener;
import com.example.moli.campus.model.impl.OnRegisterListener;
import com.example.moli.campus.util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by moli on 2019/10/4.
 * 功能：user的登录注册逻辑实现类，继承并实现IUSerModel接口里的方法
 */

public class UserModel implements IUserModel {

    //登录
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                //usename： moli
                //password: 123456
                if ("moli".equals(username) && "123456".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }



    @Override
    public void register(String username, String password, OnRegisterListener registerListener) {
        //注册

    }
}






























//    private HttpUtil httpUtil = new HttpUtil();
//
//    @Override
//    public void login(String account, String password, final OnLoginListener loginListener) {
//       HttpUtil.doGet(Urls.login_url + "?mobile=" + account + "&password=" + password, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String json = response.body().string();
//                //判断
//                try {
//                    JSONObject jsonObject = new JSONObject(json);
//                    String code = jsonObject.getString("code");
//                    if (code.equals("0")) {
//                        //登录成功,调用登录接口
//                        loginListener.loginSuccess(json);
//                    } else {
//                        //登录失败,调用登录接口
//                        loginListener.loginFailed(json);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }
//
//    @Override
//    public void register(String account, String password, final OnRegisterListener registerListener) {
//       //联网请求,注册用户
//        HttpUtil.doGet(Urls.reg_url + "?mobile=" + account + "&password=" + password, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String json = response.body().string();
//                //判断注册是否成功
//                try {
//                    JSONObject jsonObject = new JSONObject(json);
//                    String code = jsonObject.getString("code");
//                    //注册成功
//                    if (code.equals("0")) {
//                        registerListener.regSuccess(json);
//                    } else {
//                        //失败
//                        registerListener.regFailed(json);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }

