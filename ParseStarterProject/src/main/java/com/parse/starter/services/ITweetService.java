package com.parse.starter.services;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.parse.starter.domain.Tweet;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public interface ITweetService {
    void fetchAllTweets(FindCallback<ParseObject> findCallback);

    void Add(Tweet tweet, SaveCallback saveCallback);

    void Login(String userName, String password, LogInCallback logInCallback);
}
