package com.example.moli.campus.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.moli.campus.R;
import com.example.moli.campus.javabean.User;
import com.example.moli.campus.presenter.UserPresenter;
import com.example.moli.campus.view.IUserView;

public class LoginActivity extends AppCompatActivity implements IUserView,View.OnClickListener{


    private EditText mUsermobile;
    private EditText mUserpasword;
    private Button mLogin;
    private Button mReg;
    private UserPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        mUsermobile =  findViewById(R.id.et_user_name);
        mUserpasword =  findViewById(R.id.et_psw);
        mLogin =  findViewById(R.id.btn_login);
        mReg =  findViewById(R.id.btn_to_register);
        mReg.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        presenter = new UserPresenter(this);

    }



    @Override
    public String getUserName() {
        return mUsermobile.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mUserpasword.getText().toString();
    }

    @Override
    public void toActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }


    @Override
    public void showLoginError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();

    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //调用P层方法,实现登录
                presenter.login();
                break;
            case R.id.btn_register:
                //调用P层方法,实现注册
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
