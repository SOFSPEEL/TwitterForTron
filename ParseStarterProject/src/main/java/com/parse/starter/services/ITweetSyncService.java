package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public interface ITweetSyncService {
    void sync(List<Tweet> _tweets, long userId, TweetCallback tweetCallback);
}