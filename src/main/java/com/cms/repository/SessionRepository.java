package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Session;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Integer>{
    List<Session> findByConference_ConferenceID(Integer conferenceId);

}
