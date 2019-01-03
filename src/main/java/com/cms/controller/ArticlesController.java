package com.cms.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Articles;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ArticlesController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/articles")
    public Articles articles(@RequestParam(value="name", defaultValue="World") String name) {
        return new Articles(counter.incrementAndGet(), String.format(template, name));
    }

}
