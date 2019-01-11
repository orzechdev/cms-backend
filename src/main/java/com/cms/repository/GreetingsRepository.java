package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Greetings;


public interface GreetingsRepository extends CrudRepository<Greetings,Integer> {
}
