package com.jianyulu.TinyURLService.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujianyu on 5/29/17.
 */

@Service
public class TinyURLServiceImpl implements TinyURLService {
    /**
     * fields
     */
    public static final char[] encode = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    // map<longURL, shortURL>
    private Map<String, String> longToShortMap;
    // map<shortURL, longURL>
    private Map<String, String> shortToLongMap;

    /**
     * methods
     */
    // constructor
    public TinyURLServiceImpl() {
        // constructor doesn't work?
        System.out.println("DEBUG: TinyURLService constructor");
        this.longToShortMap = new HashMap<>();
        this.shortToLongMap = new HashMap<>();
        // init -> avoid first shortURL == ""
        longToShortMap.put("long", "short");
        longToShortMap.put("short", "long");
    }

    // write
    public String write(String longURL) {
        // corner case
        if (longURL == null) {
            return null;
        }
        // to do
        if (longToShortMap.containsKey(longURL)) {
            return longToShortMap.get(longURL);
        }
        String shortURL = generateShortURL();
        longToShortMap.put(longURL, shortURL);
        shortToLongMap.put(shortURL, longURL);
        return shortURL;
    }

    // read
    public String read(String shortURL) {
        String longURL = shortToLongMap.get(shortURL);
        return longURL == null ? "shortURL doesn't exist" : longURL ;
    }

    // generateShortURL
    public String generateShortURL() {
        int size = shortToLongMap.size();
        return convertTo62(size);
    }

    private String convertTo62(int size) {
        // '0' ~ '9', 'a' ~ 'z', 'A' ~ 'Z'
        String shortURL = "";
        while (size > 0) {
            shortURL = encode[size % 62] + shortURL;
            size /= 62;
        }
        return shortURL;
    }
}
