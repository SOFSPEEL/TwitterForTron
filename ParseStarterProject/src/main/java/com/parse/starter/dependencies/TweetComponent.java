package com.parse.starter.dependencies;

import com.parse.starter.services.ILoginService;
import com.parse.starter.services.INavigateService;
import com.parse.starter.services.ITweetService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={TweetModule.class})
public interface TweetComponent {
   ILoginService loginService();
    ITweetService tweetService();
    INavigateService navigateService();

}
