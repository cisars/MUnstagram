package com.example.cisar.munstagram.login.repository;

import com.example.cisar.munstagram.login.presenter.LoginPresenter;

/**
 * Created by cisar on 30/1/2018.
 */

public class LoginRepositoryImpl implements LoginRepository{

    LoginPresenter presenter;

    @Override
    public void signIn(String username, String password) {
        boolean success = false;

        if(success == true){
            presenter.loginSuccess();
        }else{
            presenter.loginError("Ocurrio un error");
        }

    }
}
