package com.example.administrator.mvplogindemo2.model;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public interface IUserModer {
     void login(String username, String password,OnLoginListener onLoginListener);
}
