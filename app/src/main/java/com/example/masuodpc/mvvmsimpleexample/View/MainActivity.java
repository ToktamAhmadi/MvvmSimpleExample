package com.example.masuodpc.mvvmsimpleexample.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.masuodpc.mvvmsimpleexample.R;
import com.example.masuodpc.mvvmsimpleexample.ViewModel.UserViewModel;
import com.example.masuodpc.mvvmsimpleexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserViewModel userViewModel=new UserViewModel(this);
        activityMainBinding.setList(userViewModel);
    }
}
