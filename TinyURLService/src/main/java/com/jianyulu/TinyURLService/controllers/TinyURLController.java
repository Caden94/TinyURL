package com.jianyulu.TinyURLService.controllers;

import com.jianyulu.TinyURLService.services.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lujianyu on 5/29/17.
 */
@RestController
public class TinyURLController {

    private final TinyURLService tinyURLService;

    @Autowired
    public TinyURLController(TinyURLService tinyURLService) {
        this.tinyURLService = tinyURLService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String write(@RequestParam(value = "shortURL", defaultValue = "without shortURL") String shortURL, @RequestParam(value = "longURL", defaultValue = "without longURL") String longURL) {
        if (!shortURL.equals("without shortURL")) {
            // exsist shortURL
            longURL = tinyURLService.read(shortURL);
            // System.out.println("shortURL: " + shortURL + " longURL: " + longURL);
            return longURL;
        } else if (!longURL.equals("without longURL")){
            shortURL = tinyURLService.write(longURL);
            // System.out.println("shortURL: " + shortURL + " longURL: " + longURL);
            return shortURL;
        } else {
            return "without valid parameter";
        }

    }
}
