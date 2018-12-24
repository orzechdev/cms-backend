
package com.cms;

import org.springframework.data.repository.CrudRepository;

import com.cms.SQLTest;


public interface ArticleRepository extends CrudRepository<ArticleTable,Integer> {
}
