package com.parse.starter.services;

import javax.inject.Inject;

public class NavigateService implements INavigateService{


    private ILoginService loginService;

    @Inject
    public NavigateService(ILoginService loginService) {

        this.loginService = loginService;
    }

}
