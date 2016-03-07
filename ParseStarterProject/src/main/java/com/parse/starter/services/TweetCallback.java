package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public abstract class TweetCallback extends Object{

    public abstract void onTweetsFetched(List<Tweet> tweets);
}
