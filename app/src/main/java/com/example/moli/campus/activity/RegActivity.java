package com.example.moli.campus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moli.campus.R;
import com.example.moli.campus.javabean.User;
import com.example.moli.campus.presenter.UserPresenter;
import com.example.moli.campus.view.IUserView;

public class RegActivity extends AppCompatActivity implements View.OnClickListener, IUserView {

    private EditText mRegmobile;
    private EditText mRegpasword;
    private Button mReg;
    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();//初始化视图

    }

    private void initView() {

        mRegmobile = (EditText) findViewById(R.id.et_reg_name);
        mRegpasword = (EditText) findViewById(R.id.et_reg_psw);
        mReg = (Button) findViewById(R.id.btn_register);
        mReg.setOnClickListener(this);
        presenter = new UserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                // 注册
                presenter.register();
                break;
            default:
                break;
        }
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }

    @Override
    public void toActivity(User user) {

    }

    @Override
    public void showLoginError() {

    }
}




