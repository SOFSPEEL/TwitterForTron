package com.parse.starter.services;

import junit.framework.TestCase;

import static org.easymock.EasyMock.createMockBuilder;

public class NavigateServiceTest extends TestCase {
    @org.junit.Test
    public void testLogin() throws Exception {

        NavigateService service = createMockBuilder(NavigateService.class).addMockedMethod("fetchAllTweets").createMock();


    }
}
