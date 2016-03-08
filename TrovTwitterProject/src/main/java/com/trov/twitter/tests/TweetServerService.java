package com.trov.twitter.tests;

import com.trov.twitter.domain.Tweet;

import java.util.Date;
import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetServerService implements ITweetServerService {

    @Override
    public List<Tweet> fetchAllTweets(long userId, Date latestDate) {


        List<Tweet> tweets;
        if (latestDate == null) {
            tweets = Tweet.find(Tweet.class, "user_id=?", Long.toString(userId));
        } else {
            tweets = Tweet.find(Tweet.class, "user_id=? AND date>?", userId + "", latestDate.getTime() + "");
        }
        return tweets;
    }

    @Override
    public boolean save(Tweet tweet) {
        tweet.save();
        return true;
    }

    @Override
    public void save(List<Tweet> tweets) {
        Tweet.saveInTx(tweets);
    }
}

