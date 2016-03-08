package com.trov.twitter.fakeserver;

/**
 * Created by steve.fiedelberg on 3/8/16.
 */
public abstract class FakeServer {
    protected void simulateServerDelay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
