package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public interface ITweetFeed {
    List<Tweet> fetchAllTweets(long userId);

    boolean save(Tweet tweet);

    int getLatestYear(List<Tweet> tweetsFromDb);
}
