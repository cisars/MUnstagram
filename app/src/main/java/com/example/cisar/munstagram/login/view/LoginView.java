package com.example.cisar.munstagram.login.view;

/**
 * Created by cisar on 22/1/2018.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();
    void goWeb();
}
