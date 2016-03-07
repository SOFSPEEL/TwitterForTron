package com.parse.starter.services;

import android.app.Activity;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface ILogin {
    boolean Login(Activity activity, String userName, String password);
}
