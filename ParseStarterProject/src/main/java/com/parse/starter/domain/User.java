package com.parse.starter.domain;

import com.orm.SugarRecord;

/**
 * Created by steve.fiedelberg on 3/5/16.
 */
public class User extends SugarRecord {
    public String userName;
    public String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


}
