package com.parse.starter.services;

import com.parse.starter.domain.Tweet;
import com.parse.starter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetService implements ITweetService {

    @Override
    public List<Tweet> fetchAllTweets() {
        return Tweet.listAll(Tweet.class);
    }

    @Override
    public boolean save(Tweet tweet) {
        tweet.save();
        return true;
    }
}

