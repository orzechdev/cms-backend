package com.cms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Review;
import com.cms.service.ReviewService;

@CrossOrigin
@RestController
public class ReviewController {

	@Autowired
    private ReviewService reviewService;

    @RequestMapping("/reviews")
    public List<Review> reviews() {
        return reviewService.getAllReviews();
    }
    
    @RequestMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable Integer reviewId) {
    	return reviewService.getReview(reviewId);   	
    }
    
    @RequestMapping(value="/reviews", method=RequestMethod.POST)
    public void addReview(@RequestBody Review review) {
    	reviewService.addReview(review); 	
    }
    
    @RequestMapping(value="/reviews/{reviewId}", method=RequestMethod.PUT)
    public void updateReview(@RequestBody Review review) {
    	reviewService.updateReview(review);
    }
    
    @RequestMapping(value="/reviews/{reviewId}", method=RequestMethod.DELETE)
    public void deleteReview(@PathVariable Integer reviewId) {
    	reviewService.deleteReview(reviewId);
    }
    
    
    
}