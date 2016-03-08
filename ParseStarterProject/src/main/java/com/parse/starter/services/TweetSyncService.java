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
    private Feed tweetService;

    public TweetSyncService(ITweetServerService tweetServerService, Feed tweetService) {

        this.tweetServerService = tweetServerService;
        this.tweetService = tweetService;
    }

    @Override
    public List<Tweet> sync(List<Tweet> tweets, long userId) {

        Date latestDate = tweets.size() > 0 ? tweets.get(0).getDate() : null;

        simulateServerDelay();

        List<Tweet> tweetsFromServer = tweetServerService.fetchAllTweets(userId, latestDate);

        List<Tweet> unsyncedTweets = new ArrayList<>();

        for (Tweet tweet : tweets) {
            if (!tweet.getSynced()) {
                tweet.setSynced(true);
                unsyncedTweets.add(tweet);
            }
        }

        if (unsyncedTweets.size() > 0) {
            tweetServerService.save(unsyncedTweets);

            Tweet.saveInTx(unsyncedTweets);

        }
        return tweetsFromServer;
    }

    private void simulateServerDelay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
