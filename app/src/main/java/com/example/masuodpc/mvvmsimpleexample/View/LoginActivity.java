package com.example.masuodpc.mvvmsimpleexample.View;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.masuodpc.mvvmsimpleexample.Model.Login;
import com.example.masuodpc.mvvmsimpleexample.R;
import com.example.masuodpc.mvvmsimpleexample.ViewModel.LoginViewModel;
import com.example.masuodpc.mvvmsimpleexample.ViewModel.factory.UserViewModelFactory;
import com.example.masuodpc.mvvmsimpleexample.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //---Create instance for data binding auto generated class file

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        //---Create instance for ViewModel class


        LoginViewModel loginViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new Login())).get(LoginViewModel.class);

        //---Set ViewModel instance to binding class

        binding.setLogin(loginViewModel);
    }
}