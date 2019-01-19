
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Article;

import java.util.List;


public interface ArticleRepository extends CrudRepository<Article,Integer> {
    public List<Article> findAllByOrderByUserAuthor_IdDesc();
    public List<Article> findByConference_ConferenceID(Integer conferenceId);
}
