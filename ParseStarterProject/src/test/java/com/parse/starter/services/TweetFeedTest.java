package com.parse.starter.services;

import com.parse.starter.domain.Tweet;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class TweetFeedTest {

    private final int userId = 1;

    @Test
    public void testThatTweetsAreSortedAccordingToMostRecent() {
        TweetDb mockTweetDb = createMock(TweetDb.class);
        TweetFeed feed = new TweetFeed(mockTweetDb);

        ArrayList<Tweet> tweets = new ArrayList<>();

        int numberItems = 20;
        int oldestYear = 1980;
        for (int i = 0; i < numberItems; i++) {
            tweets.add(new Tweet(userId, "Junk" + i, new GregorianCalendar(oldestYear + i, 10, 1).getTime()));
        }

        expect(mockTweetDb.find(userId)).andReturn(tweets);

        replay(mockTweetDb);


        List<Tweet> tweetsFromDb = feed.fetchAllTweets(userId);
        Assert.assertEquals(numberItems, tweetsFromDb.size());
        int newestYear = oldestYear + numberItems - 1;
        Assert.assertEquals(newestYear, feed.getLatestYear(tweetsFromDb));

        verify(mockTweetDb);

    }


}
