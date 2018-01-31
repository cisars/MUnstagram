package com.example.cisar.munstagram.login.interactor;

import com.example.cisar.munstagram.login.presenter.LoginPresenter;
import com.example.cisar.munstagram.login.repository.LoginRepository;
import com.example.cisar.munstagram.login.repository.LoginRepositoryImpl;

/**
 * Created by cisar on 23/1/2018.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter){
        this.presenter = presenter;
        repository = new LoginRepositoryImpl();
    }

    @Override
    public void signIn(String username, String password) {
        repository.signIn(username, password);

    }
}
