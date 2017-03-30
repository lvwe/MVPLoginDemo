package com.example.administrator.mvplogindemo2.model;

import com.example.administrator.mvplogindemo2.bean.User;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public interface OnLoginListener {
     void LoginSuccess(User user);

    void loginFailed();
}
