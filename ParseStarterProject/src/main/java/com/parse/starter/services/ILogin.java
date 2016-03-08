package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.Views.LoginActivity;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface ILogin {
    boolean LoginManually(Activity activity, String userName, String password);

    void LoginAutomatically(Activity activity);
}
