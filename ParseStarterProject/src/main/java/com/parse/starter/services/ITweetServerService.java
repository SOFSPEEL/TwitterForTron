package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.Date;
import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public interface ITweetServerService {
    List<Tweet> fetchAllTweets(long userId, Date latestDate);

    boolean save(Tweet tweet);

    void save(List<Tweet> tweets);
}
