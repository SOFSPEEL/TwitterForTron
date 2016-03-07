package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TweetSyncService implements ITweetSyncService {
    private ITweetServerService tweetServerService;
    private ITweetFeed tweetService;

    public TweetSyncService(ITweetServerService tweetServerService, ITweetFeed tweetService) {

        this.tweetServerService = tweetServerService;
        this.tweetService = tweetService;
    }

    @Override
    public List<Tweet> sync(long userId, TweetCallback tweetCallback) {
        List<Tweet> tweets = tweetService.fetchAllTweets(userId);

        Date latestDate = tweets.size() > 0 ? tweets.get(0).getDate() : null;

        tweetCallback.Tweets = tweetServerService.fetchAllTweets(userId, latestDate);

        List<Tweet> unsyncedTweets = new ArrayList<>();
        for (Tweet tweet : tweets) {
            if (!tweet.getSynced()){
                unsyncedTweets.add(tweet);

        }
            if (unsyncedTweets.size() > 0) {
                tweetServerService.save(unsyncedTweets);
            }
        }

        return tweets;
    }
}
