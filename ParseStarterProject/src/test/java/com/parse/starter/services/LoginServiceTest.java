package com.parse.starter.services;

import android.app.Activity;

import com.parse.starter.domain.User;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class LoginServiceTest extends TestBase {

    private final String validUsername = "trov";
    private final String validPassword = "user";

    @Before
    public void before(){
        createMocks();
    }

    @Test
    public void testValidLoginResultInNavigationToTweets() throws Exception {

        //expectations
        List<User> users = Arrays.asList(new User());
        expect(mockUser.find(validUsername, validPassword)).andReturn(users);
        mockNav.NavigateTo(mockActivity, "Tweets");

        //replay
        replay(mockNav, mockUser, mockActivity);

        //run
        new LoginService(mockNav, mockUser).Login(mockActivity, validUsername, validPassword);

        //verify
        verify(mockNav, mockUser, mockActivity);
    }



}
