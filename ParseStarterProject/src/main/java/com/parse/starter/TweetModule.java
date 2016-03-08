package com.parse.starter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.parse.starter.services.ILogin;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetDb;
import com.parse.starter.services.ITweetFeed;
import com.parse.starter.services.ITweetServerService;
import com.parse.starter.services.ITweetSyncService;
import com.parse.starter.services.Login;
import com.parse.starter.services.NavigateService;
import com.parse.starter.services.ServiceManager;
import com.parse.starter.services.TweetDb;
import com.parse.starter.services.TweetServerService;
import com.parse.starter.services.TweetFeed;
import com.parse.starter.services.TweetSyncService;

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
    ITweetFeed provideTweetFeed(ITweetDb tweetDb) {
        return new TweetFeed(tweetDb);
    }

    @Provides
    @Singleton
    ITweetServerService provideTweetServerService() {
        return new TweetServerService();
    }

    @Provides
    @Singleton
    ILogin provideLoginService(INavigateService navigateService) {
        return new Login(navigateService);
    }

    @Provides
    @Singleton
    ITweetDb provideTweetDb() {
        return new TweetDb();
    }


    @Provides @Singleton
    INavigateService provideNavigateService() {
        return new NavigateService();
    }



    @Provides
    ServiceManager provideServiceManager(Application application) {
        return new ServiceManager(application);
    }

    @Provides
    @Singleton
    ITweetSyncService provideTweetSyncService(ITweetServerService tweetServerService, ITweetFeed tweetService) {
        return new TweetSyncService(tweetServerService, tweetService);
    }
}

