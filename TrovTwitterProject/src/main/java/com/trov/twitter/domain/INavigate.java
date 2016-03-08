package com.trov.twitter.domain;

import android.app.Activity;

import com.trov.twitter.domain.User;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface INavigate {
    void To(Activity activity, String path, User user);

    void ToToast(Activity activity, String toast);
}

