
package com.cms.repository;

import com.cms.entity.User;
import org.springframework.data.repository.CrudRepository;

import com.cms.entity.Review;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review,Integer> {
    public List<Review> findAllByOrderByUser_IdDesc();
    public Review findFirstByUserAndArticleID(User user, Integer articleID);
}
