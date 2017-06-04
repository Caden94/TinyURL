package com.jianyulu.TinyURLService.model;

/**
 * Created by lujianyu on 6/4/17.
 */
public class TinyURL {
    private String shortURL;
    private String longURL;

    public TinyURL() {

    }

    public TinyURL(String shortURL, String longURL) {
        this.shortURL = shortURL;
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public String getLongURL() {
        return longURL;
    }
}
