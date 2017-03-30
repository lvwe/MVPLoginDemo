package com.example.administrator.mvplogindemo2.model;

import com.example.administrator.mvplogindemo2.bean.User;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class UserModel implements IUserModer {

    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {

        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("abc".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.LoginSuccess(user);
                }else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();

    }
}
