package com.example.masuodpc.mvvmsimpleexample.ViewModel;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.masuodpc.mvvmsimpleexample.Model.Login;
import com.example.masuodpc.mvvmsimpleexample.View.MainActivity;

import java.util.logging.Handler;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> welcome = new MutableLiveData<>();
    private  MutableLiveData<Integer> busy;

    private Login login;
    private Context context;

    public LoginViewModel(Context context,Login login)
    {
        this.login=login;
        this.context=context;
        this.welcome.setValue(login.getWelcomeMessage());

    }
    //-- Get Mutable Data instance for progress bar


    public MutableLiveData<Integer> getBusy() {
        if(busy==null)
        {
            busy=new MutableLiveData<>();
            busy.setValue(View.GONE);
        }
        return busy;
    }
    //-- event after login button
    public void onLoginClick()
    {
        login.setEmail(email.getValue());
        login.setPassword(password.getValue());
        if (!login.isValidEmail()){Toast.makeText(context, "ایمیل وارد شده اشتباه است.", Toast.LENGTH_SHORT).show(); }
        else if (!login.isValidPassword()){Toast.makeText(context, "رمز عبور کمتر از 6 کاراکتر است.", Toast.LENGTH_SHORT).show(); }
        //we can use mothod from LoginViewModle for check email$pass from database
        else {
            getBusy().setValue(View.VISIBLE);
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "با موفقیت وارد شدید.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("USER_OBJ", login);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            },500);


            }
    }
}
