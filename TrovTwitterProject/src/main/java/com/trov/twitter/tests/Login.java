package com.trov.twitter.tests;

import android.app.Activity;

import com.parse.twitter.R;
import com.trov.twitter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class Login implements ILogin {

    private INavigate navigateService;
    private IUserServerService userServerService;

    public Login(INavigate navigateService, IUserServerService userServerService) {

        this.navigateService = navigateService;
        this.userServerService = userServerService;
    }

    @Override
    public boolean LoginManually(Activity activity, String userName, String password) {

        User user = userServerService.find(userName, password);

        boolean userExists = user != null;

        if (userExists){
            user.setLoggedIn(true);
            userServerService.save(user);
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



