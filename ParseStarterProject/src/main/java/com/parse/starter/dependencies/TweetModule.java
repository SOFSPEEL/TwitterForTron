package com.parse.starter.dependencies;

import com.parse.starter.services.ILoginService;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetService;
import com.parse.starter.services.LoginService;
import com.parse.starter.services.NavigateService;
import com.parse.starter.services.TweetService;

import javax.inject.Singleton;

import dagger.Component;
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

    @Provides @Singleton
    ILoginService provideLoginService() {
        return new LoginService();
    }

    @Provides @Singleton
    INavigateService provideNavigateService(ILoginService loginService) {
        return new NavigateService(loginService);
    }
}

