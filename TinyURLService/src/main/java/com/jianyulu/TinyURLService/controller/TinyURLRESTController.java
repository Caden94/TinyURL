package com.jianyulu.TinyURLService.controller;

import com.jianyulu.TinyURLService.model.TinyURL;
import com.jianyulu.TinyURLService.model.TinyURLREST;
import com.jianyulu.TinyURLService.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lujianyu on 5/29/17.
 */
@RestController
public class TinyURLRESTController {

    private TinyURLService tinyURLService;

    @Autowired
    public TinyURLRESTController(TinyURLService tinyURLService) {
        this.tinyURLService = tinyURLService;
    }

    @RequestMapping(value = "/{shortURL}", method = RequestMethod.GET)
    public TinyURLREST read(@PathVariable(name = "shortURL") String shortURL) {
        if (shortURL != null) {
            return new TinyURLREST(shortURL, tinyURLService.read(shortURL));
        } else {
            return new TinyURLREST();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TinyURLREST write(@RequestBody TinyURLREST tinyURLREST) {
        if (tinyURLREST.getLongURL() != null) {
            String longURL = tinyURLREST.getLongURL();
            return new TinyURLREST(tinyURLService.write(longURL), longURL);
        } else {
            return new TinyURLREST();
        }
    }
}
