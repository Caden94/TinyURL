package com.jianyulu.TinyURLService.controller;

import com.jianyulu.TinyURLService.model.TinyURL;
import com.jianyulu.TinyURLService.model.TinyURLREST;
import com.jianyulu.TinyURLService.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/longURL", method = RequestMethod.POST)
    public TinyURLREST write(@RequestBody TinyURLREST tinyURLREST) {
        if (tinyURLREST.getLongURL() != null) {
            String longURL = tinyURLREST.getLongURL();
            return new TinyURLREST(tinyURLService.write(longURL), longURL);
        } else {
            return new TinyURLREST();
        }
    }

    @RequestMapping(value = "/longURLs", method = RequestMethod.POST)
    public List<TinyURLREST> write(@RequestBody List<TinyURLREST> tinyURLRESTs) {
        List<TinyURLREST> reponseBody = new ArrayList<>();
        System.out.println(tinyURLRESTs.isEmpty());
        for (TinyURLREST tinyURLREST : tinyURLRESTs) {
            if (tinyURLREST.getLongURL() != null) {
                String longURL = tinyURLREST.getLongURL();
                reponseBody.add(new TinyURLREST(tinyURLService.write(longURL), longURL));
            } else {
                reponseBody.add(new TinyURLREST());
            }
        }
        return reponseBody;
    }

    @GetMapping(value = "/JSONTest")
    public List<TinyURLREST> jsonTest() {
        List<TinyURLREST> reponseBody = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            reponseBody.add(new TinyURLREST(String.valueOf(i), String.valueOf(i)));
        }
        return reponseBody;
    }
}
