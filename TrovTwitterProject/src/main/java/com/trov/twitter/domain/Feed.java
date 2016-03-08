package com.trov.twitter.domain;

import com.trov.twitter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public interface Feed {
    List<Tweet> fetchAllTweets(long userId);

    boolean save(Tweet tweet);

    int getLatestYear(List<Tweet> tweetsFromDb);
}
