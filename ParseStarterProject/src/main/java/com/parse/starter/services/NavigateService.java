package com.parse.starter.services;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.parse.starter.Views.TweetsActivity;

import javax.inject.Inject;

public class NavigateService implements INavigateService {

    public static final String extraUserId = "UserId";

    @Inject
    public NavigateService() {
    }

    @Override
    public void NavigateTo(Activity activity, String path, User user) {
        switch (path) {
            case "Tweets":
                Intent intent = new Intent(activity, TweetsActivity.class);
                intent.putExtra(extraUserId, user.getId());
                activity.startActivity(intent);
        }
    }

    @Override
    public void NavigateToToast(Activity activity, String toast) {
        Toast.makeText(activity, toast, Toast.LENGTH_LONG).show();
    }
}
