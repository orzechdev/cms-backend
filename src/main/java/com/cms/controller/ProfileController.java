package com.cms.controller;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Profile;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ProfileController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/profile")
    public Profile authors(@RequestParam(value="name", defaultValue="World") String name) {
        return new Profile(counter.incrementAndGet(), String.format(template, name));
    }

}
