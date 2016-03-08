package com.trov.twitter.tests;

import com.trov.twitter.domain.User;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public interface IUserServerService {
    User find(String userName, String password);

    void save(User user);
}
