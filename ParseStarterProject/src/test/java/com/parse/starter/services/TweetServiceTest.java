package com.parse.starter.services;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;

import junit.framework.TestCase;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IMockBuilder;


import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.*;
/**
 * Created by steve.fiedelberg on 3/4/16.
 */
public class TweetServiceTest extends TestCase {

    @org.junit.Test
    public void testFetchAllTweets() throws Exception {

        TweetService service = createMockBuilder(TweetService.class).addMockedMethod("fetchAllTweets").createMock();
        Capture<FindCallback<ParseObject>> findCallbackCapture = newCapture();

        FindCallback mock = createMockBuilder(FindCallback.class).createMock();

        replay(service);

        service.fetchAllTweets(mock);

    //    List<ParseObject> objects = Collections.emptyList();
    //    findCallbackCapture.getValue().done(objects, null);

        verify(service);

    }

}

