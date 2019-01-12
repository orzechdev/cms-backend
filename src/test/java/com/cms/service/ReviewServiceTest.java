package com.cms.service;

import com.cms.entity.Review;
import com.cms.entity.User;
import com.cms.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import(com.cms.service.ReviewServiceTestContextConfiguration.class)
public class ReviewServiceTest {


    @Autowired
    private ReviewService reviewService;
    @MockBean
    private ReviewRepository reviewRepository;

    private List<Review> testReviews = new ArrayList<>();

    @Before
    public void setUp() {
        User testAuthor = new User(
                "test-username",
                "TestPassword",
                "Jan",
                "Kowalski",
                "test@test.test",
                123456789
        );
        testReviews.add(new Review(0));
        testReviews.add(new Review(1));
        testReviews.add(new Review(2));


        Mockito.when(reviewRepository.findAll()).thenReturn(testReviews);
        Mockito.when(reviewRepository.findById(0)).thenReturn(Optional.of(testReviews.get(0)));
        Mockito.when(reviewRepository.findById(1)).thenReturn(Optional.of(testReviews.get(1)));
        Mockito.when(reviewRepository.findById(2)).thenReturn(Optional.of(testReviews.get(2)));
    }

    @Test
    public void getAllConferencesTest() {
        List<Review> reviews = reviewService.getAllReviews();

        assertEquals(testReviews, reviews);
    }

    @Test
    public void getConferenceTest() {
        Review review0 = reviewService.getReview(0);
        Review review1 = reviewService.getReview(1);
        Review review2 = reviewService.getReview(2);

        assertEquals(testReviews.get(0), review0);
        assertEquals(testReviews.get(1), review1);
        assertEquals(testReviews.get(2), review2);
    }

    @Test
    public void addConferenceTest() {
        reviewService.addReview(testReviews.get(0));

        Mockito.verify(reviewRepository).save(testReviews.get(0));
    }

    @Test
    public void updateConferenceTest() {
        reviewService.updateReview(testReviews.get(0));

        Mockito.verify(reviewRepository).save(testReviews.get(0));
    }

    @Test
    public void deleteConferenceTest() {
        reviewService.deleteReview(0);

        Mockito.verify(reviewRepository).deleteById(0);
    }
}

@TestConfiguration
class ReviewServiceTestContextConfiguration {
    @Bean
    public ReviewService reviewService() {
        return new ReviewService();
    }
}

