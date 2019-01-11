package com.cms.service;

import com.cms.entity.User;
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

    public class AppUserPrincipal implements UserDetails {
        private User user;

        public AppUserPrincipal(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(user.getRole()));

            return authorities;
        }

        public Integer getId() {
            return user.getId();
        }

        @Override
        @JsonIgnore
        @JsonProperty(value = "password")
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        public String getRole() {
            return user.getRole();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public String getFirstName() {
            return user.getFirstName();
        }

        public String getLastName() {
            return user.getLastName();
        }

        public String getBio() {
            return user.getBio();
        }

        public String getEmailAddress() {
            return user.getEmailAddress();
        }

        public Integer getContactNumber() {
            return user.getContactNumber();
        }
    }
}
