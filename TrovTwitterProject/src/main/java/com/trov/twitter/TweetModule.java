package com.trov.twitter;

import android.app.Application;

import com.trov.twitter.domain.ILogin;
import com.trov.twitter.domain.INavigate;
import com.trov.twitter.domain.ITweetDb;
import com.trov.twitter.domain.Feed;
import com.trov.twitter.fakeserver.ITweetServerService;
import com.trov.twitter.domain.ITweetSyncService;
import com.trov.twitter.fakeserver.IUserServerService;
import com.trov.twitter.domain.Login;
import com.trov.twitter.domain.Navigate;
import com.trov.twitter.domain.TweetDb;
import com.trov.twitter.fakeserver.TweetServerService;
import com.trov.twitter.domain.TweetFeed;
import com.trov.twitter.domain.TweetSyncService;
import com.trov.twitter.fakeserver.UserServerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steve.fiedelberg on 3/4/16.
 */
@Module
public class TweetModule {


    @Provides
    @Singleton
    Feed provideTweetFeed(ITweetDb tweetDb) {
        return new TweetFeed(tweetDb);
    }

    @Provides
    @Singleton
    ITweetServerService provideTweetServerService() {
        return new TweetServerService();
    }

    @Provides
    @Singleton
    IUserServerService provideUserServerService() {
        return new UserServerService();
    }

    @Provides
    @Singleton
    ILogin provideLoginService(INavigate navigateService, IUserServerService userServerService) {
        return new Login(navigateService, userServerService);
    }

    @Provides
    @Singleton
    ITweetDb provideTweetDb() {
        return new TweetDb();
    }


    @Provides @Singleton
    INavigate provideNavigateService() {
        return new Navigate();
    }



    @Provides
    @Singleton
    ITweetSyncService provideTweetSyncService(ITweetServerService tweetServerService, Feed tweetService) {
        return new TweetSyncService(tweetServerService);
    }
}

