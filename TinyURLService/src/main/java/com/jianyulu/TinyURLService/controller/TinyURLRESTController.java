package com.jianyulu.TinyURLService.controller;

import com.jianyulu.TinyURLService.model.TinyURL;
import com.jianyulu.TinyURLService.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lujianyu on 5/29/17.
 */
@RestController
public class TinyURLRESTController {

    @Autowired
    private TinyURLService tinyURLService;

    @RequestMapping(value = "/{shortURL}", method = RequestMethod.GET)
    public TinyURL read(@PathVariable(name = "shortURL") String shortURL) {
        if (shortURL != null) {
            return new TinyURL(shortURL, tinyURLService.read(shortURL));
        } else {
            return new TinyURL();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TinyURL write(@RequestBody TinyURL tinyURL) {
        if (tinyURL.getLongURL() != null) {
            String longURL = tinyURL.getLongURL();
            return new TinyURL(tinyURLService.write(longURL), longURL);
        } else {
            return new TinyURL();
        }
    }
}