package com.example.administrator.mvplogindemo2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.mvplogindemo2.R;
import com.example.administrator.mvplogindemo2.precenter.UserLoginPresenter;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class UserLoginActivity extends AppCompatActivity implements ILoginView{
    private EditText mEdtUserName,mEdtPassword;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mProgressBar;

    private UserLoginPresenter mUserLoginPrecenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initViews();
        mProgressBar.setVisibility(View.GONE);
    }

    private void initViews() {
        mEdtUserName = (EditText) findViewById(R.id.edt_username);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear= (Button) findViewById(R.id.btn_clear);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPrecenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPrecenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEdtUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString();
    }

    @Override
    public void cleanUsername() {
        mEdtUserName.setText("");
    }

    @Override
    public void cleanPassword() {
        mEdtPassword.setText("");
    }

    @Override
    public void showLogin() {
       mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLogin() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this, "login success to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();

    }
}
