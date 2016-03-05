package com.parse.starter.dependencies;

import com.parse.starter.domain.Tweet;
import com.parse.starter.services.ITweetService;
import com.parse.starter.services.TweetService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
@Singleton
@Component(modules = {TweetModule.class})
public interface TweetComponent {

    ITweetService provideTweetService();

}
