package com.parse.starter.services;

import junit.framework.TestCase;

import static org.easymock.EasyMock.createMockBuilder;

public class LoginServiceTest extends TestCase {
    @org.junit.Test
    public void testLogin() throws Exception {

        LoginService service = createMockBuilder(LoginService.class).addMockedMethod("fetchAllTweets").createMock();

    }
}
