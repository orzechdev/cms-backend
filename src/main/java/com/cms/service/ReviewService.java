package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import com.cms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Review;
import com.cms.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

//    @PreAuthorize("hasAuthority('user')") TODO: think about authorization roles, and where to check them...
	public List<Review> getAllReviews() {
		List<Review> reviews = new ArrayList<>();
		reviewRepository.findAll().forEach(reviews::add);
		return reviews;
	}

	public Review getReview(Integer reviewId) {
		return reviewRepository.findById(reviewId).get();
	}

	public Review getUserReviewForArticle(User user, Integer articleID) {
		return reviewRepository.findFirstByUserAndArticleID(user, articleID);
	}

	public void addReview(Review review) {
		reviewRepository.save(review);
	}
	
	public void updateReview(Review review) {
		reviewRepository.save(review);
	}

	public void deleteReview(Integer reviewId) {
		reviewRepository.deleteById(reviewId);		
	}

}
