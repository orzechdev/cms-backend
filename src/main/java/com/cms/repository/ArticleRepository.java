
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Article;


public interface ArticleRepository extends CrudRepository<Article,Integer> {
}
