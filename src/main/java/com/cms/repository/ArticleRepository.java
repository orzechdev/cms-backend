
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.ArticleTable;


public interface ArticleRepository extends CrudRepository<ArticleTable,Integer> {
}
