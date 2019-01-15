package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import com.cms.entity.Article;
import com.cms.entity.Presentation;
import com.cms.entity.Session;
import com.cms.repository.PresentationRepository;
import com.cms.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cms.entity.Conference;
import com.cms.repository.ConferenceRepository;

@Service
public class ConferenceService {
	
	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private PresentationRepository presentationRepository;

	@Autowired
    private SessionRepository sessionRepository;

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

	public List<Presentation> getConferencePresentations(Integer conferenceId) {
		List<Presentation> presentations = new ArrayList<>();
		presentationRepository.findBySession_Conference_ConferenceID(conferenceId).forEach(presentations::add);
		return presentations;
	}

    public List<Article> getConferenceArticles(Integer conferenceId) {
        List<Article> articles = new ArrayList<>();
        presentationRepository.findBySession_Conference_ConferenceID(conferenceId).forEach(presentation ->
            articles.add(presentation.getArticle())
        );
        return articles;
    }
}
