package com.trov.twitter.tests;

import android.app.Activity;

import com.parse.twitter.R;
import com.trov.twitter.domain.User;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class LoginServiceTest extends TestBase {

    @Before
    public void before() {

        createMocks();
    }

    @Test
    public void testValidLoginResultsInNavigationToTweets() throws Exception {

        //expectations

        mockNav.To(isA(Activity.class), matches("Tweets"), anyObject(User.class));
        expect(mockUserServerService.find("Trov", "User")).andReturn(new User());
        mockUserServerService.save(anyObject(User.class));

        //replay
        replay(mockNav, mockActivity, mockUserServerService);

        //run
        new Login(mockNav, mockUserServerService).LoginManually(mockActivity, "Trov", "User");

        //verify
        verify(mockNav, mockActivity, mockUserServerService);
    }

    @Test
    public void testInValidLoginResultsInInvalidUserToast() throws Exception {

        //expectations

        expect(mockActivity.getString(R.string.invalid_login)).andReturn("Invalid Login");

        mockNav.ToToast(mockActivity, "Invalid Login");
        //replay
        replay(mockNav, mockActivity);

        //run
        new Login(mockNav, mockUserServerService).LoginManually(mockActivity, "Tron1", "User");

        //verify
        verify(mockNav, mockActivity);
    }

    @Test
    public void testEmptyLoginResultsInInvalidUserToast() throws Exception {

        //expectations

        expect(mockActivity.getString(R.string.invalid_login)).andReturn("Invalid Login");

        mockNav.ToToast(mockActivity, "Invalid Login");
        //replay
        replay(mockNav, mockActivity);

        //run
        new Login(mockNav, mockUserServerService).LoginManually(mockActivity, "", "user");

        //verify
        verify(mockNav, mockActivity);
    }

}

