package com.example.masuodpc.mvvmsimpleexample.ViewModel.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.example.masuodpc.mvvmsimpleexample.Model.Login;
import com.example.masuodpc.mvvmsimpleexample.ViewModel.LoginViewModel;



public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory
{
    private Login login;
    private Context context;


    public UserViewModelFactory(Context context, Login login)
    {
        this.context = context;
        this.login = login;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass)
    {
        return (T) new LoginViewModel(context, login);
    }
}