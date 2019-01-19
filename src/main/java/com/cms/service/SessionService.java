package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Session;
import com.cms.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;

//    @PreAuthorize("hasAuthority('user')") TODO: think about authorization roles, and where to check them...
	public List<Session> getAllSessions(Integer conferenceId) {
		List<Session> sessions = new ArrayList<>();
		sessionRepository.findByConference_ConferenceID(conferenceId).forEach(sessions::add);
		return sessions;
	}
	
	public List<Session> getAllSessions() {
		List<Session> sessions = new ArrayList<>();
		sessionRepository.findAll().forEach(sessions::add);
		return sessions;
	}

	public Session getSession(Integer sessionId) {
		return sessionRepository.findById(sessionId).get();
	}

	public void addSession(Session session) {
		sessionRepository.save(session);
	}
	
	public void updateSession(Session session) {
		sessionRepository.save(session);
	}

	public void deleteSession(Integer sessionId) {
		sessionRepository.deleteById(sessionId);		
	}

}
