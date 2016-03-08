package com.trov.twitter.domain;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.trov.twitter.Views.LoginActivity;
import com.trov.twitter.Views.TweetsActivity;

import javax.inject.Inject;

public class Navigate implements INavigate {

    public static final String extraUserId = "UserId";

    @Inject
    public Navigate() {
    }

    @Override
    public void To(Activity activity, String path, User user) {
        switch (path) {
            case "Tweets":
                Intent intent = new Intent(activity, TweetsActivity.class);
                intent.putExtra(extraUserId, user.getId());
                activity.startActivity(intent);
                break;
            case "Logout":{
                intent = new Intent(activity, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void ToToast(Activity activity, String toast) {
        Toast.makeText(activity, toast, Toast.LENGTH_LONG).show();
    }
}
