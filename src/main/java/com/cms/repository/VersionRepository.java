
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Version;

import java.util.List;


public interface VersionRepository extends CrudRepository<Version,Integer> {
    public List<Version> findAllByOrderByVersionIDDescArticle_ArticleIDDesc();
}
