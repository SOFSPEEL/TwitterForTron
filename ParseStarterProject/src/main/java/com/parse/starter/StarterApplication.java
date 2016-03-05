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

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.starter.dependencies.DaggerTweetComponent;
import com.parse.starter.dependencies.TweetComponent;
import com.parse.starter.dependencies.TweetModule;
import com.parse.starter.domain.Tweet;
import com.parse.starter.services.ITweetService;


public class StarterApplication extends Application {

  private ITweetService tweetService;

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    ParseObject.registerSubclass(Tweet.class);

    // Add your initialization code here
    Parse.initialize(this);

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

    TweetComponent component = DaggerTweetComponent.builder().tweetModule(new TweetModule()).build();
    tweetService = component.tweetService();

  }


  public ITweetService getTweetService() {
    return tweetService;
  }
}
