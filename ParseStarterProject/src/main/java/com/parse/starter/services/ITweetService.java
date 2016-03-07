package com.parse.starter.services;

import com.parse.starter.domain.Tweet;
import com.parse.starter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public interface ITweetService {
    List<Tweet> fetchAllTweets();

    boolean save(Tweet tweet);
}
