package com.parse.starter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.parse.starter.services.ILoginService;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetService;
import com.parse.starter.services.IUserService;
import com.parse.starter.services.LoginService;
import com.parse.starter.services.NavigateService;
import com.parse.starter.services.ServiceManager;
import com.parse.starter.services.TweetService;
import com.parse.starter.services.UserService;

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
    ITweetService provideTweetService() {
        return new TweetService();
    }

    @Provides
    @Singleton
    ILoginService provideLoginService(INavigateService navigateService, IUserService userService) {
        return new LoginService(navigateService, userService);
    }

    @Provides
    @Singleton
    IUserService provideUserService() {
        return new UserService();
    }

    @Provides
    INavigateService provideNavigateService() {
        return new NavigateService();
    }

    @Provides
    public NetworkInfo provideNetworkInfo(Application application) {
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo();
    }

    @Provides
    ServiceManager provideServiceManager(Application application) {
        return new ServiceManager(application);
    }


}

