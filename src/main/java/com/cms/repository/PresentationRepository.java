package com.cms.repository;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Presentation;

import java.util.List;


public interface PresentationRepository extends CrudRepository<Presentation,Integer> {
    List<Presentation> findBySession_Conference_ConferenceID(Integer conferenceId);
}
