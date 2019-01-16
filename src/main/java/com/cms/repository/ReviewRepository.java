
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;

import com.cms.entity.Review;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Review,Integer> {
    public List<Review> findAllByOrderByUser_IdDesc();
}
