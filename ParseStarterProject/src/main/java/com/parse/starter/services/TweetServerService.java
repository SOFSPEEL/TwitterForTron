package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetServerService implements ITweetServerService {

    @Override
    public List<Tweet> fetchAllTweets(long userId) {
        return Tweet.find(Tweet.class, "user_id=?", Long.toString(userId));
    }

    @Override
    public boolean save(Tweet tweet) {
        tweet.save();
        return true;
    }
}

