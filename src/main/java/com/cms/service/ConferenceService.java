package com.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cms.entity.*;
import com.cms.repository.PresentationRepository;
import com.cms.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cms.repository.ConferenceRepository;

@Service
public class ConferenceService {
	
	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private PresentationRepository presentationRepository;

	@Autowired
    private SessionRepository sessionRepository;

	@Autowired
	private VersionService versionService;

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

    public List<Version> getConferenceArticlesVersions(Integer conferenceId) {
        List<Article> articles = getConferenceArticles(conferenceId);
        return versionService.getLatestVersions().stream().filter(version ->
            articles.stream().anyMatch(article ->
                article.getArticleID().equals(version.getArticle().getArticleID())
            )
        ).collect(Collectors.toList());
    }
}
