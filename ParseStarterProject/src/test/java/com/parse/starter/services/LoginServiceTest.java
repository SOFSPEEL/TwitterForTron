package com.parse.starter.services;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.parse.starter.R;
import com.parse.starter.domain.User;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
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
        List<User> users = CreateSingleUser();
        expect(mockUser.find("tron", "user")).andReturn(users);

        mockNav.NavigateTo(mockActivity, "Tweets");

        //replay
        replay(mockNav, mockUser, mockActivity);

        //run
        new LoginService(mockNav, mockUser).Login(mockActivity, "tron", "user");

        //verify
        verify(mockNav, mockUser, mockActivity);
    }

    @Test
    public void testInValidLoginResultsInInvalidUserToast() throws Exception {

        //expectations
        List<User> users = CreateNoUser();
        expect(mockUser.find("tron1", "user")).andReturn(users);
        expect(mockActivity.getString(R.string.invalid_login)).andReturn("Invalid Login");

        mockNav.NavigateToToast(mockActivity, "Invalid Login");
        //replay
        replay(mockNav, mockUser, mockActivity);

        //run
        new LoginService(mockNav, mockUser).Login(mockActivity, "tron1", "user");

        //verify
        verify(mockNav, mockUser, mockActivity);
    }

}
