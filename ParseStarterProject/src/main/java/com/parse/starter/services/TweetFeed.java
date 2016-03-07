package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetFeed implements ITweetFeed {

    private ITweetDb tweetDb;

    public TweetFeed(ITweetDb tweetDb) {

        this.tweetDb = tweetDb;
    }


    @Override
    public List<Tweet> fetchAllTweets(long userId) {
        List<Tweet> tweets = tweetDb.find(userId);
        sort(tweets);
        return tweets;
    }


    @Override
    public boolean save(Tweet tweet) {
        tweetDb.save(tweet);
        return true;
    }

    @Override
    public int getLatestYear(List<Tweet> tweetsFromDb) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tweetsFromDb.get(0).getDate());
        return cal.get(Calendar.YEAR);
    }

    private void sort(List<Tweet> tweets) {
        Collections.sort(tweets, new Comparator<Tweet>() {
            @Override
            public int compare(final Tweet object1, final Tweet object2) {
                return object2.getDate().compareTo(object1.getDate());
            }
        });
    }
}

