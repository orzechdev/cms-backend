package com.cms.service;

import com.cms.entity.Article;
import com.cms.entity.Review;
import com.cms.entity.User;
import com.cms.principal.AppUserPrincipal;
import com.cms.repository.ArticleRepository;
import com.cms.repository.ReviewRepository;
import com.cms.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

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

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<List<Article>> getAuthors() {
        List<Article> articles = new ArrayList<>(articleRepository.findAllByOrderByUserAuthor_IdDesc());
        List<List<Article>> result = new ArrayList<>();
        Integer lastAuthorID = -1;
        List<Article> lastNewAuthorsArticles = null;
        for (Article article : articles) {
            Integer currAuthorID = article.getUserAuthor().getId();
            if (!currAuthorID.equals(lastAuthorID)) {
                if (lastNewAuthorsArticles != null)
                    result.add(lastNewAuthorsArticles);
                lastNewAuthorsArticles = new ArrayList<>();
                lastNewAuthorsArticles.add(article);
                lastAuthorID = currAuthorID;
            } else {
                if (lastNewAuthorsArticles == null)
                    lastNewAuthorsArticles = new ArrayList<>();
                lastNewAuthorsArticles.add(article);
            }
        }
        if (lastNewAuthorsArticles != null)
            result.add(lastNewAuthorsArticles);
        return result;
    }

    public List<List<Review>> getReviewers() {
        List<Review> reviews = new ArrayList<>(reviewRepository.findAllByOrderByUser_IdDesc());
        List<List<Review>> result = new ArrayList<>();
        Integer lastAuthorID = -1;
        List<Review> lastNewAuthorsReviews = null;
        for (Review review : reviews) {
            Integer currAuthorID = review.getUser().getId();
            if (!currAuthorID.equals(lastAuthorID)) {
                if (lastNewAuthorsReviews != null)
                    result.add(lastNewAuthorsReviews);
                lastNewAuthorsReviews = new ArrayList<>();
                lastNewAuthorsReviews.add(review);
                lastAuthorID = currAuthorID;
            } else {
                if (lastNewAuthorsReviews == null)
                    lastNewAuthorsReviews = new ArrayList<>();
                lastNewAuthorsReviews.add(review);
            }
        }
        if (lastNewAuthorsReviews != null)
            result.add(lastNewAuthorsReviews);
        return result;
    }

}
