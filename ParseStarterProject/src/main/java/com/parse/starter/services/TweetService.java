package com.parse.starter.services;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.starter.domain.Tweet;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetService implements ITweetService {




    @Override
    public void fetchAllTweets(FindCallback<ParseObject> findCallback) {

        ParseQuery.getQuery("Tweet").orderByDescending("updatedAt").findInBackground(findCallback);
    }

    @Override
    public void Add(Tweet tweet, SaveCallback saveCallback) {
        tweet.saveInBackground(saveCallback);
    }

    @Override
    public void Login(String userName, String password, LogInCallback logInCallback) {
        ParseUser.logInInBackground(userName, password, logInCallback);
    }
}
