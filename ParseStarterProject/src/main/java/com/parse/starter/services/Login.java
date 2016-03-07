package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.R;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class Login implements ILogin {

    private INavigateService navigateService;

    public Login(INavigateService navigateService) {

        this.navigateService = navigateService;
    }

    @Override
    public boolean Login(Activity activity, String userName, String password) {

        User user = userName == "tron" && password == "user" ? new User() : null;
        boolean isLoggedIn = user != null;
        if (isLoggedIn) {
            navigateService.NavigateTo(activity, "Tweets", user);
        } else {
            navigateService.NavigateToToast(activity, activity.getString(R.string.invalid_login));
        }
        return isLoggedIn;

    }

}
