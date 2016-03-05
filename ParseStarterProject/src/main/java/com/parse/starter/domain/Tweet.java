package com.parse.starter.domain;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Tweet")
public class Tweet extends ParseObject {

    public String getMessage() {
        return getString("message");
    }

    public void setMessage(String value) {
        put("message", value);
    }

    @Override
    public String toString() {
        return getMessage();

    }
}
