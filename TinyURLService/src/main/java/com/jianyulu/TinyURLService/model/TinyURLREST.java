package com.jianyulu.TinyURLService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lujianyu on 6/8/17.
 */
@Data
@NoArgsConstructor
public class TinyURLREST {
    private String shortURL;
    private String longURL;

    public TinyURLREST(String shortURL, String longURL) {
        this.shortURL = shortURL;
        this.longURL = longURL;
    }
}
