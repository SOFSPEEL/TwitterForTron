package com.parse.starter.dependencies;

import com.parse.starter.services.ITweetService;
import com.parse.starter.services.TweetService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
@Module
public class TweetModule {

    @Provides @Singleton
    ITweetService provideTweetService() {
        return new TweetService();
    }
}
