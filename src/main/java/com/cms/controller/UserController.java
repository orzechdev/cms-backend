package com.cms.controller;
import java.util.concurrent.atomic.AtomicLong;

import com.cms.entity.User;
import com.cms.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private AppUserDetailsService userDetailsService;

    @RequestMapping("/user")
    public AppUserDetailsService.AppUserPrincipal getUser(@AuthenticationPrincipal AppUserDetailsService.AppUserPrincipal user ) {
        return user;
    }

    @RequestMapping("/user/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userDetailsService.getUser(userId);
    }

    public User updateUser(@PathVariable Integer userId) {
        return null; //TODO
    }
}
