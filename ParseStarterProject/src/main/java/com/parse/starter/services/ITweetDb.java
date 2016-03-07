package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public interface ITweetDb {
    List<Tweet> find(long userId);
}
