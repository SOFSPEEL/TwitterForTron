package com.parse.starter.services;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.parse.starter.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TestBase {
    protected Navigate mockNav;
    protected Activity mockActivity;

    protected void createMocks() {
        mockNav = createMock(Navigate.class);
        mockActivity = createNiceMock(Activity.class);
    }

    @NonNull
    protected List<User> CreateNoUser() {
        return new ArrayList<>();
    }
}
