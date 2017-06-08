package com.jianyulu.TinyURLService.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lujianyu on 6/8/17.
 */
public interface TinyURLRepository extends JpaRepository<TinyURL, Long> {
    TinyURL findTinyURLByShortURL(Long ShortURL);
}
