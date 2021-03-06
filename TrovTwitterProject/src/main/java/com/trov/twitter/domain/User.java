package com.trov.twitter.domain;

import com.orm.SugarRecord;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public class User extends SugarRecord {

    private boolean loggedIn;
    private String name;
    private String password;

    public User(){}

    public User(String name, String password) {

        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
