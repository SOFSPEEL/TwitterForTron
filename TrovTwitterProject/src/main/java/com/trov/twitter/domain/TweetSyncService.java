package com.trov.twitter.domain;

import com.trov.twitter.fakeserver.ITweetServerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TweetSyncService implements ITweetSyncService {
    private ITweetServerService tweetServerService;

    public TweetSyncService(ITweetServerService tweetServerService) {

        this.tweetServerService = tweetServerService;
    }

    @Override
    public List<Tweet> sync(List<Tweet> tweets, long userId) {

        Date latestDate = tweets.size() > 0 ? tweets.get(0).getDate() : null;

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


}
