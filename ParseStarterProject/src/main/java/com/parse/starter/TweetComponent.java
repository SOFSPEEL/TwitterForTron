package com.parse.starter;

import android.util.Log;

import com.parse.starter.Views.LoginActivity;
import com.parse.starter.Views.TweetsActivity;
import com.parse.starter.services.ILoginService;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, TweetModule.class})
public interface TweetComponent {

    void inject(LoginActivity activity);
    void inject(TweetsActivity activity);
}
