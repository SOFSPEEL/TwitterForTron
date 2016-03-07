/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;

import com.orm.SugarContext;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.starter.domain.User;
import com.parse.starter.services.ILoginService;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetService;
import com.parse.starter.services.LoginService;

import java.util.List;

import static com.parse.ParseACL.*;


public class TweetApplication extends Application {

    private TweetComponent component;

    public TweetApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);

        component = DaggerTweetComponent.builder()
                .appModule(new AppModule(this))
                .tweetModule(new TweetModule()).build();

        SeedUser();

    }

    private void SeedUser() {
        List<User> users = User.find(User.class, "user_name = ? and password = ?", "Trov", "User");
        boolean isLoggedIn = users.size() > 0;
        if (!isLoggedIn)
            User.save(new User("Trov", "User"));
    }

    public TweetComponent getTweetComponent() {
        return component;
    }
}
