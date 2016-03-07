package com.parse.starter.services;

import android.app.Activity;

import junit.framework.TestCase;

import static org.easymock.EasyMock.createMock;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TestBase {
    protected NavigateService mockNav;
    protected UserService mockUser;
    protected Activity mockActivity;

    protected void createMocks() {
        mockNav = createMock(NavigateService.class);
        mockUser = createMock(UserService.class);
        mockActivity = createMock(Activity.class);
    }
}
