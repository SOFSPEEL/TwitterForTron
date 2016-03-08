package com.trov.twitter.tests;

import com.trov.twitter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public interface ITweetDb {
    List<Tweet> find(long userId);

    void save(Tweet tweet);
}
