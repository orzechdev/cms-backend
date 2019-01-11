
package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Version;


public interface VersionRepository extends CrudRepository<Version,Integer> {
}
