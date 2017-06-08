package com.jianyulu.TinyURLService.service.impl;

import com.jianyulu.TinyURLService.model.TinyURL;
import com.jianyulu.TinyURLService.model.TinyURLRepository;
import com.jianyulu.TinyURLService.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lujianyu on 5/29/17.
 */

@Service
public class TinyURLServiceImpl implements TinyURLService {
    /**
     * fields
     */
    public static final String encode = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * methods
     */
    private TinyURLRepository tinyURLRepository;

    @Autowired
    public TinyURLServiceImpl(TinyURLRepository tinyURLRepository) {
        this.tinyURLRepository = tinyURLRepository;
    }

    @Override
    public String write(String longURL) {
        // corner case
        // save
        TinyURL tinyURL = new TinyURL(longURL);
        return convert10To62(tinyURLRepository.save(tinyURL).getShortURL());
    }

    @Override
    public String read(String shortURL) {
        TinyURL tinyURL = tinyURLRepository.findTinyURLByShortURL(convert62To10(shortURL));
        return tinyURL.getLongURL();
    }

    private String convert10To62(Long input) {
        // '0' ~ '9', 'a' ~ 'z', 'A' ~ 'Z'
        String shortURL = "";
        while (input > 0) {
            shortURL = encode.charAt((int)(input % 62L)) + shortURL;
            input /= 62L;
        }
        return shortURL;
    }

    private Long convert62To10(String input) {
        char[] chars = new StringBuilder(input).reverse().toString().toCharArray();
        long n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += toBase10(encode.indexOf(chars[i]), i);
        }
        return n;
    }

    private long toBase10(long n, long pow) {
        return n * (long) Math.pow(10, pow);
    }
}
