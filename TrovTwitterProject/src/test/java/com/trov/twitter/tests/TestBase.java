package com.trov.twitter.tests;

import android.app.Activity;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TestBase {
    protected Navigate mockNav;
    protected Activity mockActivity;
    protected UserServerService mockUserServerService;


    protected void createMocks() {
        mockNav = createMock(Navigate.class);
        mockActivity = createNiceMock(Activity.class);
        mockUserServerService = createMock(UserServerService.class);
    }

}
