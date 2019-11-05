package com.example.masuodpc.mvvmsimpleexample.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.io.Serializable;

public class Login implements Serializable {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isValidEmail()
    {
        if(this.email != null && !TextUtils.isEmpty(email) )
        {
            return true;
        }

        return false;
    }

    public boolean isValidPassword()
    {
        if(this.password != null && this.password.length() >= 6)
        {
            return true;
        }

        return false;
    }


    public String getWelcomeMessage() {
        return "خوش آمدید\n" + this.getEmail();
    }
}
