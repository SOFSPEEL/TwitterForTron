package com.parse.starter.services;

import android.app.Activity;
import android.content.Intent;

import com.parse.starter.Views.TweetsActivity;

import javax.inject.Inject;

public class NavigateService implements INavigateService {

   @Inject
    public NavigateService() {
    }

    @Override
    public void NavigateTo(Activity activity, String path) {
        switch (path) {
            case "Tweets":
                activity.startActivity(new Intent(activity, TweetsActivity.class));

        }

    }
}
