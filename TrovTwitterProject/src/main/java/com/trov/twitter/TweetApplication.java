/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.trov.twitter;

import android.app.Application;
import android.support.annotation.NonNull;

import com.orm.SugarContext;
import com.trov.twitter.domain.User;


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

        seedWithUser();
    }


    public TweetComponent getTweetComponent() {
        return component;
    }

    @NonNull
    private User seedWithUser() {

        User user = User.findById(User.class, 1L);
        if (user == null) {
            user = new User();
            user.setName("Trov");
            user.setPassword("User");
            user.setId(1L);
            user.save();
        }
        return user;
    }

}
