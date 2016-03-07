package com.parse.starter.services;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TweetSyncService implements ITweetSyncService {
    private ITweetServerService tweetServerService;
    private ITweetFeed tweetService;

    public TweetSyncService(ITweetServerService tweetServerService, ITweetFeed tweetService) {

        this.tweetServerService = tweetServerService;
        this.tweetService = tweetService;
    }
}
