package com.cms.service;

import com.cms.entity.Review;
import com.cms.entity.User;
import com.cms.principal.AppUserPrincipal;
import com.cms.repository.ReviewRepository;
import com.cms.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserPrincipal(user);
    }

    public User getUser(Integer userId) {
        Optional<User> userObject = userRepository.findById(userId);
        return userRepository.findById(userId).get();
    }

//    public List<User> getAuthors() {
//        List<User> authors = new ArrayList<>();
//        return authors;
//    }

//    public List<User> getReviewers() {
//        List<Review> reviewersUsers = reviewRepository.findAll();
//        List<User> reviewers = reviewRepository.findReviewers(); //new ArrayList<>();
////        for (Review review : reviewersUsers) {
////            review.getReviewer().getId() reviewers.add(new UserProfile(review.getReviewer()));
////        }
//        return reviewers;
//    }

}
