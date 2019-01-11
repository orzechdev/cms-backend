package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Presentation;


public interface PresentationRepository extends CrudRepository<Presentation,Integer> {
}
