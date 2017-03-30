package com.example.administrator.mvplogindemo2.precenter;

import android.os.Handler;
import android.view.inputmethod.InputMethodManager;

import com.example.administrator.mvplogindemo2.bean.User;
import com.example.administrator.mvplogindemo2.model.IUserModer;
import com.example.administrator.mvplogindemo2.model.OnLoginListener;
import com.example.administrator.mvplogindemo2.model.UserModel;
import com.example.administrator.mvplogindemo2.view.ILoginView;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class UserLoginPresenter {
    private IUserModer mIUserModer;
    private ILoginView mILoginView;
    private Handler mHandler = new Handler();
    private InputMethodManager mInputMethodManager;

    public UserLoginPresenter(ILoginView ILoginView) {
        this.mILoginView = ILoginView;
        this.mIUserModer = new UserModel();
    }
    public void login(){

        mILoginView.showLogin();
        mIUserModer.login(mILoginView.getUserName(), mILoginView.getPassword(), new OnLoginListener() {
            @Override
            public void LoginSuccess(User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.toMainActivity();
                        mILoginView.hideLogin();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mILoginView.showFailedError();
                        mILoginView.hideLogin();
                    }
                });
            }
        });
    }
    public void clear(){
        mILoginView.cleanUsername();
        mILoginView.cleanPassword();
    }
}
