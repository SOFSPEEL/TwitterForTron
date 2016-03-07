package com.parse.starter;

import com.parse.starter.Views.LoginActivity;
import com.parse.starter.Views.TweetsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, TweetModule.class})
public interface TweetComponent {

    void inject(LoginActivity activity);
    void inject(TweetsActivity activity);
}
