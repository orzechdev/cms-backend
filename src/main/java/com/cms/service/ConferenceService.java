package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cms.entity.Conference;
import com.cms.repository.ConferenceRepository;

@Service
public class ConferenceService {
	
	@Autowired
	private ConferenceRepository conferenceRepository;

//    @PreAuthorize("hasAuthority('user')") TODO: think about authorization roles, and where to check them...
	public List<Conference> getAllConferences() {
		List<Conference> conferences = new ArrayList<>();
		conferenceRepository.findAll().forEach(conferences::add);
		return conferences;
	}

	public Conference getConference(Integer conferenceId) {
		return conferenceRepository.findById(conferenceId).get();
	}

	public void addConference(Conference conference) {
		conferenceRepository.save(conference);
	}
	
	public void updateConference(Conference conference) {
		conferenceRepository.save(conference);
	}

	public void deleteConference(Integer conferenceId) {
		conferenceRepository.deleteById(conferenceId);		
	}

}
