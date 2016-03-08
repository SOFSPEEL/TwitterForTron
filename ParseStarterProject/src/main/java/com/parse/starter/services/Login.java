package com.parse.starter.services;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.parse.starter.R;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class Login implements ILogin {

    private INavigate navigateService;

    public Login(INavigate navigateService) {

        this.navigateService = navigateService;
    }

    @Override
    public boolean Login(Activity activity, String userName, String password) {

        boolean isValid = userName.equals("Trov") && password.equals("User");
        User user = isValid ? createUser() : null;
        boolean isLoggedIn = user != null;
        if (isLoggedIn) {
            navigateService.NavigateTo(activity, "Tweets", user);
        } else {
            navigateService.NavigateToToast(activity, activity.getString(R.string.invalid_login));
        }
        return isLoggedIn;

    }

    @NonNull
    private User createUser() {
        User user = new User();
        user.setId(1);
        return user;
    }

}
