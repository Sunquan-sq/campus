package com.example.moli.campus.presenter;

import com.example.moli.campus.activity.LoginActivity;
import com.example.moli.campus.activity.MainActivity;
import com.example.moli.campus.activity.SplashActivity;
import com.example.moli.campus.javabean.User;
import com.example.moli.campus.model.UserModel;
import com.example.moli.campus.model.impl.IUserModel;
import com.example.moli.campus.model.impl.OnLoginListener;
import com.example.moli.campus.model.impl.OnRegisterListener;
import com.example.moli.campus.view.IUserView;


import android.content.Intent;
import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.LogRecord;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by moli on 2019/10/4.
 * 功能：监听状态、调用视图
 */

public class UserPresenter {
    private IUserView userView;
    private IUserModel userModel;
    private Handler mHandler = new Handler();


    public UserPresenter(IUserView userView) {
        this.userView = userView;
        this.userModel = new UserModel();
    }

    public void login() {

        userModel.login(userView.getUserName(), userView.getUserPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userView.toActivity(user);
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userView.showLoginError();

                    }
                });

            }
        });
    }







    public void register() {

        userModel.register(userView.getUserName(), userView.getUserPassword(), new OnRegisterListener() {

            @Override
            public void regSuccess(String json) {

            }

            @Override
            public void regFailed(String json) {

            }
        });
    }
}



