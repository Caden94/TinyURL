package com.jianyulu.TinyURLService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lujianyu on 6/4/17.
 */
@Data
@NoArgsConstructor
public class TinyURL {

    private String shortURL;
    private String longURL;

    public TinyURL(String shortURL, String longURL) {
        this.shortURL = shortURL;
        this.longURL = longURL;
    }
}
