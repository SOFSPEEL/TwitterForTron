package com.parse.starter.services;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.parse.starter.domain.User;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.createMock;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public class TestBase {
    protected NavigateService mockNav;
    protected UserService mockUser;
    protected Activity mockActivity;

    protected void createMocks() {
        mockNav = createMock(NavigateService.class);
        mockUser = createMock(UserService.class);
        mockActivity = createMock(Activity.class);
    }

    @NonNull
    protected List<User> CreateSingleUser() {
        return Arrays.asList(new User());
    }

    @NonNull
    protected List<User> CreateNoUser() {
        return new ArrayList<>();
    }
}
