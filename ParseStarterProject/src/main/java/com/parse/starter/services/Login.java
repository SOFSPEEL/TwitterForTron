package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.R;
import com.parse.starter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class Login implements ILogin {

    private INavigate navigateService;

    public Login(INavigate navigateService) {

        this.navigateService = navigateService;
    }

    @Override
    public boolean LoginManually(Activity activity, String userName, String password) {

        List<User> users = User.find(User.class, "name=? AND password=?", userName, password);

        boolean userExists = users.size() > 0;

        if (userExists) {
            User user = users.get(0);
            user.setLoggedIn(true);
            user.save();
            navigateService.To(activity, "Tweets", user);
        } else {
            navigateService.ToToast(activity, activity.getString(R.string.invalid_login));
        }


        return userExists;
    }

    @Override
    public void LoginAutomatically(Activity activity) {

        List<User> users = User.find(User.class, "logged_in=?", 1 + "");
        boolean userExists = users.size() > 0;
        if (userExists) {
            User user = users.get(0);
            navigateService.To(activity, "Tweets", user);
        }
    }
}



