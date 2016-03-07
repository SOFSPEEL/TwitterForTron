package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.domain.User;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public interface ILoginService {
    boolean Login(Activity activity, String userName, String password);
}
