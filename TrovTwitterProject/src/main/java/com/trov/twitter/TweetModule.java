package com.trov.twitter;

import android.app.Application;

import com.trov.twitter.tests.ILogin;
import com.trov.twitter.tests.INavigate;
import com.trov.twitter.tests.ITweetDb;
import com.trov.twitter.tests.Feed;
import com.trov.twitter.tests.ITweetServerService;
import com.trov.twitter.tests.ITweetSyncService;
import com.trov.twitter.tests.IUserServerService;
import com.trov.twitter.tests.Login;
import com.trov.twitter.tests.Navigate;
import com.trov.twitter.tests.ServiceManager;
import com.trov.twitter.tests.TweetDb;
import com.trov.twitter.tests.TweetServerService;
import com.trov.twitter.tests.TweetFeed;
import com.trov.twitter.tests.TweetSyncService;
import com.trov.twitter.tests.UserServerService;

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
    ServiceManager provideServiceManager(Application application) {
        return new ServiceManager(application);
    }

    @Provides
    @Singleton
    ITweetSyncService provideTweetSyncService(ITweetServerService tweetServerService, Feed tweetService) {
        return new TweetSyncService(tweetServerService, tweetService);
    }
}

