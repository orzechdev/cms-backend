package com.cms.controllers;
import java.util.concurrent.atomic.AtomicLong;

import com.cms.ConferenceDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ConferenceDetailsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/conferencedetails")
    public ConferenceDetails conferenceDetails(@RequestParam(value="name", defaultValue="World") String name) {
        return new ConferenceDetails(counter.incrementAndGet(), String.format(template, name));
    }

}
