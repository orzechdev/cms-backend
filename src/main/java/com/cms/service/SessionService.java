package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import com.cms.entity.Presentation;
import com.cms.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Session;
import com.cms.repository.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private PresentationRepository presentationRepository;

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

	public Presentation getPresentation(Integer presentationId) {
		return presentationRepository.findById(presentationId).get();
	}


	public void addConferencePresentation(Presentation presentation) {
		presentationRepository.save(presentation);
	}
	public void updateConferencePresentation(Presentation presentation) {
		presentationRepository.save(presentation);
	}
	public void deleteConferencePresentation(Integer presentationId) {
		presentationRepository.deleteById(presentationId);
	}

    public void addConferencePresentationMany(List<Presentation> presentations) {
        presentationRepository.saveAll(presentations);
    }
//    public void deleteConferencePresentationMany(List<Presentation> presentations) {
//	    presentations.forEach(presentation ->
//	        deleteConferencePresentation(presentation.getpresentationID())
//        );
//    }
    public void deleteConferencePresentationMany(List<Integer> presentationsIds) {
        presentationsIds.forEach(presentationId ->
            deleteConferencePresentation(presentationId)
        );
    }
}
