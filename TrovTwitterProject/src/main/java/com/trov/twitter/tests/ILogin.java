package com.trov.twitter.tests;

import android.app.Activity;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface ILogin {
    boolean LoginManually(Activity activity, String userName, String password);

    void LoginAutomatically(Activity activity);
}
