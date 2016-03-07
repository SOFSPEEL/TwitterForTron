package com.parse.starter.services;

/**
 * Created by steve.fiedelberg on 3/7/16.
 */
public class User implements Comparable<User>{

    private String userName;
    private String password;
    private long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public long isId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(User another) {
        Long longId=new Long(id);
        Long anotherLongId=new Long(another.id);
        return longId.compareTo(anotherLongId);
    }
}
