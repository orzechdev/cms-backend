package com.cms.service;

import com.cms.entity.User;
import com.cms.principal.AppUserPrincipal;
import com.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

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

}
