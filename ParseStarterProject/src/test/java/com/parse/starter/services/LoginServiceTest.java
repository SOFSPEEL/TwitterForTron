package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.R;

import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import bolts.Capture;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.matches;
import static org.easymock.EasyMock.newCapture;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class LoginServiceTest extends TestBase {


    @Before
    public void before(){
        createMocks();
    }

    @Test
    public void testValidLoginResultsInNavigationToTweets() throws Exception {

        //expectations

        mockNav.NavigateTo(isA(Activity.class), matches("Tweets"), anyObject(User.class));

        //replay
        replay(mockNav, mockActivity);

        //run
        new Login(mockNav).Login(mockActivity, "Trov", "User");

        //verify
        verify(mockNav, mockActivity);
    }

    @Test
    public void testInValidLoginResultsInInvalidUserToast() throws Exception {

        //expectations
        List<User> users = CreateNoUser();
        expect(mockActivity.getString(R.string.invalid_login)).andReturn("Invalid Login");

        mockNav.NavigateToToast(mockActivity, "Invalid Login");
        //replay
        replay(mockNav, mockActivity);

        //run
        new Login(mockNav).Login(mockActivity, "Tron1", "User");

        //verify
        verify(mockNav, mockActivity);
    }
    @Test
    public void testEmptyLoginResultsInInvalidUserToast() throws Exception {

        //expectations
        List<User> users = CreateNoUser();
        expect(mockActivity.getString(R.string.invalid_login)).andReturn("Invalid Login");

        mockNav.NavigateToToast(mockActivity, "Invalid Login");
        //replay
        replay(mockNav, mockActivity);

        //run
        new Login(mockNav).Login(mockActivity, "", "user");

        //verify
        verify(mockNav, mockActivity);
    }

}

