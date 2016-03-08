package com.trov.twitter;

import com.trov.twitter.Views.LoginActivity;
import com.trov.twitter.Views.TweetsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, TweetModule.class})
public interface TweetComponent {

    void    inject(LoginActivity activity);
    void inject(TweetsActivity activity);
}
