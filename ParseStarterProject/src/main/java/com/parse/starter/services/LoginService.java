package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.R;
import com.parse.starter.domain.User;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class LoginService implements ILoginService {

    private INavigateService navigateService;
    private IUserService userService;

    public LoginService(INavigateService navigateService, IUserService userService) {

        this.navigateService = navigateService;
        this.userService = userService;
    }

    @Override
    public boolean Login(Activity activity, String userName, String password) {

        List<User> users = userService.find(userName, password);
        boolean isLoggedIn = users.size() > 0;
        if (isLoggedIn) {
            navigateService.NavigateTo(activity, "Tweets");
        } else {
            navigateService.NavigateToToast(activity, activity.getString(R.string.invalid_login));
        }
        return isLoggedIn;

    }
}
