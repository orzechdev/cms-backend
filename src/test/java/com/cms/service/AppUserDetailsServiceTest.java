package com.cms.service;

import com.cms.entity.User;
import com.cms.principal.AppUserPrincipal;
import com.cms.repository.ArticleRepository;
import com.cms.repository.ReviewRepository;
import com.cms.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import(com.cms.service.AppUserDetailsServiceTestContextConfiguration.class)
public class AppUserDetailsServiceTest {


    @Autowired
    private AppUserDetailsService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private ArticleRepository articleRepository;
    @MockBean
    private ReviewRepository reviewRepository;

    private List<User> testUsers = new ArrayList<>();


    @Before
    public void setUp() {
        User testUser1 = new User(
                0,
                "test-username1",
                "TestPassword",
                "Jan",
                "Kowalski",
                "test@test.test",
                123456789,
                "user1Role",
                "user1Bio"
        );

        User testUser2 = new User(
                1,
                "test-username2",
                "TestPassword",
                "Jan",
                "Kowalski",
                "test@test.test",
                123456789,
                "user2role",
                "user2bio"
        );
        testUsers.add(testUser1);
        testUsers.add(testUser2);


        Mockito.when(userRepository.findById(0)).thenReturn(Optional.of(testUsers.get(0)));
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(testUsers.get(1)));
        Mockito.when(userRepository.findByUsername("test-username1")).thenReturn(testUsers.get(0));
        Mockito.when(userRepository.findByUsername("test-username2")).thenReturn(testUsers.get(1));
    }


    @Test
    public void getUserTest() {
        User user0 = userService.getUser(0);
        User user1 = userService.getUser(1);

        assertEquals(testUsers.get(0), user0);
        assertEquals(testUsers.get(1), user1);
    }

    @Test
    public void loadUserByUsernameTest() {
        UserDetails userDetails1 = userService.loadUserByUsername("test-username1");
        UserDetails userDetails2 = userService.loadUserByUsername("test-username2");


        assertEquals(new AppUserPrincipal(testUsers.get(0)), userDetails1);
        assertEquals(new AppUserPrincipal(testUsers.get(1)), userDetails2);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void shouldThrowUsernameNotFoundException() throws UsernameNotFoundException {
        userService.loadUserByUsername("xyz");
    }
}

@TestConfiguration
class AppUserDetailsServiceTestContextConfiguration {
    @Bean
    public AppUserDetailsService userService() {
        return new AppUserDetailsService();
    }
}
