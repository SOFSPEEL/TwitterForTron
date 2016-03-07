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
    public void sync(List<Tweet> tweets, long userId, TweetCallback tweetCallback) {

        Date latestDate = tweets.size() > 0 ? tweets.get(0).getDate() : null;
        new FetchAllTweetsThread(tweetCallback, userId, latestDate, tweets).run();

    }

    public class FetchAllTweetsThread implements Runnable{

        private TweetCallback tweetCallback;
        private long userId;
        private Date latestDate;
        private List<Tweet> tweets;

        public FetchAllTweetsThread(TweetCallback tweetCallback, long userId, Date latestDate, List<Tweet> tweets){
            this.tweetCallback = tweetCallback;
            this.userId = userId;
            this.latestDate = latestDate;
            this.tweets = tweets;
        }


        @Override
        public void run() {

            simulateServerDelay();

            tweetCallback.onTweetsFetched(tweetServerService.fetchAllTweets(userId, latestDate));

            List<Tweet> unsyncedTweets = new ArrayList<>();
            for (Tweet tweet : tweets) {
                if (!tweet.getSynced()) {
                    tweet.setSynced(true);
                    unsyncedTweets.add(tweet);
                }
            }

            if (unsyncedTweets.size() > 0) {
                tweetServerService.save(unsyncedTweets);
                for (Tweet tweet : unsyncedTweets) {
                    tweet.save();
                }
            }
        }

        private void simulateServerDelay() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
