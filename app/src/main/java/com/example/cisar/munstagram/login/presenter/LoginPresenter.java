package com.example.cisar.munstagram.login.presenter;

/**
 * Created by cisar on 23/1/2018.
 */

public interface LoginPresenter {

    void signIn(String username, String password); // Interactor
    void loginSuccess();
    void loginError(String error);

}
