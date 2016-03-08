package com.trov.twitter.domain;

import com.orm.SugarRecord;

/**
 *
 */
public class TweetServer extends SugarRecord {

    long userId;
    String message;

    public TweetServer(long userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
