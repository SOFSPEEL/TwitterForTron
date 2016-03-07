package com.parse.starter.domain;

import com.orm.SugarRecord;

public class Tweet extends SugarRecord {

    String message;

    public Tweet(){}
    public Tweet(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
