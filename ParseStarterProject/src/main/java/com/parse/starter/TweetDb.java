package com.parse.starter;

import com.parse.starter.domain.Tweet;
import com.parse.starter.services.ITweetDb;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public class TweetDb implements ITweetDb {
    @Override
    public List<Tweet> find(long userId) {
        return Tweet.find(Tweet.class, "user_id=?", userId + "");
    }

    @Override
    public void save(Tweet tweet) {
        Tweet.save(tweet);
    }
}