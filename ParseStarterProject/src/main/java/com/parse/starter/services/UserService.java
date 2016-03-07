package com.parse.starter.services;

import com.parse.starter.domain.User;

import java.util.List;

public class UserService implements IUserService{

    @Override
    public List<User> find(String userName, String password) {
        return User.find(User.class, "user_name = ? and password = ?", userName, password);
    }
}
