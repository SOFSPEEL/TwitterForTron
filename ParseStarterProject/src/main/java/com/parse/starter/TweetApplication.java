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

import java.util.List;


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


    }


    public TweetComponent getTweetComponent() {
        return component;
    }
}
