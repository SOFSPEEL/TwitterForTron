package com.parse.starter.domain;

import com.orm.SugarRecord;

import java.util.Date;

public class Tweet extends SugarRecord {

    boolean synced;
    long userId;
    String message;
    Date date;

    public Tweet(){

    }

    public Tweet(long userId, String message) {
        this.userId = userId;
        this.message = message;
        this.synced = false;
        date = new Date();
    }

    public Tweet(int userId, String message, Date date) {
        this.userId = userId;
        this.message = message;
        this.synced = false;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean getSynced() {
        return synced;
    }
}
