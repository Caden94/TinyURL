package com.jianyulu.TinyURLService.services;

/**
 * Created by lujianyu on 5/29/17.
 */
public interface TinyURLService {
    String write(String longURL);
    String read(String shortURL);
}
