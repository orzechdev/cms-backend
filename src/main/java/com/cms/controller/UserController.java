package com.cms.controller;
import java.security.Principal;
import java.util.List;

import com.cms.entity.User;
import com.cms.service.AppUserDetailsService;
import com.cms.principal.AppUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private AppUserDetailsService userDetailsService;

    @RequestMapping("/user")
    public AppUserPrincipal getUser(@AuthenticationPrincipal AppUserPrincipal user ) {
        return user;
    }

    @RequestMapping("/user/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userDetailsService.getUser(userId);
    }

//    @RequestMapping("/authors")
//    public List<User> getAuthors() {
//        return userDetailsService.getAuthors();
//    }

//    @RequestMapping("/reviewers")
//    public List<Object[]> getReviewers() {
//        System.out.println(userDetailsService.getReviewers());
//        return null;
//    }

    public User updateUser(@PathVariable Integer userId) {
        return null; //TODO
    }
}
