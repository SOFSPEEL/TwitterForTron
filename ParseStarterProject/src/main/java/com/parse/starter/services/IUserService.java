package com.parse.starter.services;

import com.parse.starter.domain.User;

import java.util.List;

/**
 * Created by steve.fiedelberg on 3/6/16.
 */
public interface IUserService {
    List<User> find(String userName, String password);
}
