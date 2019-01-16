package com.cms.controller;
import java.security.Principal;
import java.util.List;

import com.cms.entity.Article;
import com.cms.entity.Review;
import com.cms.entity.User;
import com.cms.service.AppUserDetailsService;
import com.cms.principal.AppUserPrincipal;
import com.cms.service.ArticleService;
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

    @RequestMapping("/authors")
    public List<List<Article>> getAuthors() {
        return userDetailsService.getAuthors();
    }

    @RequestMapping("/reviewers")
    public List<List<Review>> getReviewers() {
        return userDetailsService.getReviewers();
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public void updateUser(@AuthenticationPrincipal AppUserPrincipal userPrincipal, @RequestBody User user) {
        if (userPrincipal != null && userPrincipal.getId().equals(user.getId())) {
            User userEdit = userPrincipal.getUser();
            if (user.getUsername() != null) userEdit.setUsername(user.getUsername());
            if (user.getEmailAddress() != null) userEdit.setEmailAddress(user.getEmailAddress());
            if (user.getBio() != null) userEdit.setBio(user.getBio());
            if (user.getPassword() != null) userEdit.setPassword(user.getPassword());
            if (user.getContactNumber() != null) userEdit.setContactNumber(user.getContactNumber());
            if (user.getFirstName() != null) userEdit.setFirstName(user.getFirstName());
            if (user.getLastName() != null) userEdit.setLastName(user.getLastName());
            if (user.getRole() != null) userEdit.setRole(user.getRole());
            userDetailsService.updateUser(userEdit);
        }
    }
}
