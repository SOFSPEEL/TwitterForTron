package com.trov.twitter.tests;

import com.trov.twitter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public class UserServerService implements IUserServerService {
    @Override
    public User find(String userName, String password) {
        List<User> users = User.find(User.class, "name=? AND password=?", userName, password);
        return (users.size() > 0) ? users.get(0) : null;
    }

    @Override
    public void save(User user) {
        user.save();
    }
}
