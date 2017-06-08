package com.jianyulu.TinyURLService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lujianyu on 6/4/17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "TinyURL")
public class TinyURL {
    @Id
    @GeneratedValue
    private Long shortURL;
    private String longURL;

    public TinyURL(String longURL) {
        this.longURL = longURL;
    }

}
