package com.example.administrator.mvplogindemo2.view;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public interface ILoginView {
    //获取用户名
    String getUserName();
    //获取密码
    String getPassword();
    //清除用户名
    void cleanUsername();
    //清除密码
    void cleanPassword();
    //给用户提示
    void showLogin();
    void hideLogin();
    //登录失败与成功
    void toMainActivity();
    void showFailedError();
//    对于View的接口，去观察功能上的操作，然后考虑：
//
//    该操作需要什么？（getUserName, getPassword）
//    该操作的结果，对应的反馈？(toMainActivity, showFailedError)
//    该操作过程中对应的友好的交互？(showLoading, hideLoading)
}
