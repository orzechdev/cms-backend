
package com.cms.controller;
import java.util.List;
import java.util.stream.Collectors;

import com.cms.entity.Presentation;
import com.cms.service.ArticleService;
import com.cms.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Session;
import com.cms.service.SessionService;

@CrossOrigin
@RestController
public class SessionController {

    @Autowired
    private ConferenceService conferenceService;

	@Autowired
    private SessionService sessionService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/conferences/{conferenceId}/sessions")
    public List<Session> sessions(@PathVariable Integer conferenceId) {
        return sessionService.getAllSessions(conferenceId);
    }
    
    @RequestMapping("/conferences/{conferenceId}/sessions/{sessionId}")
    public Session getSession(@PathVariable Integer sessionId) {
    	return sessionService.getSession(sessionId);   	
    }
    
    @RequestMapping(value="/conferences/{conferenceId}/sessions", method=RequestMethod.POST)
    public void addSession(@RequestBody Session session, @PathVariable Integer conferenceId) {
        session.setConference(conferenceService.getConference(conferenceId));
    	sessionService.addSession(session);
    }
    
    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}", method=RequestMethod.PUT)
    public void updateSession(@RequestBody Session session, @PathVariable Integer conferenceId) {
        session.setConference(conferenceService.getConference(conferenceId));
    	sessionService.updateSession(session);
    }
    
    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}", method=RequestMethod.DELETE)
    public void deleteSession(@PathVariable Integer sessionId) {
    	sessionService.deleteSession(sessionId);
    }


    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}/presentations", method=RequestMethod.POST)
    public void addConferencePresentation(@RequestBody Presentation presentation, @PathVariable Integer sessionId, @PathVariable Integer articleId) {
        presentation.setSession(sessionService.getSession(sessionId));
        presentation.setArticle(articleService.getArticle(articleId));
        sessionService.addConferencePresentation(presentation);
    }

    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}/presentations", method=RequestMethod.PUT)
    public void updateConferencePresentation(@RequestBody Presentation presentation, @PathVariable Integer sessionId, @PathVariable Integer articleId) {
        presentation.setSession(sessionService.getSession(sessionId));
        presentation.setArticle(articleService.getArticle(articleId));
        sessionService.updateConferencePresentation(presentation);
    }

    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}/presentations/{presentationId}", method=RequestMethod.DELETE)
    public void deleteConferencePresentation(@PathVariable Integer presentationId) {
        sessionService.deleteConferencePresentation(presentationId);
    }

    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}/presentationsMany", method=RequestMethod.POST)
    public void addConferenceManyPresentation(@RequestBody List<Presentation> presentations, @PathVariable Integer conferenceId, @PathVariable Integer sessionId, @PathVariable Integer articleId) {
        List<Presentation> repoPresentations = conferenceService.getConferenceSessionPresentations(conferenceId, sessionId);
//        List<Presentation> toDeletePresentations = repoPresentations.stream().map(repoPresentation -> {
//            return presentations.stream().noneMatch(presentation -> presentation.getpresentationID() == presentation.getpresentationID()) ? repoPresentation : null;
//        }).collect(Collectors.toList());
//        sessionService.deleteConferencePresentationMany(toDeletePresentations);
        List<Presentation> preparedPresentations = presentations.stream().map(presentation -> {
            presentation.setSession(sessionService.getSession(sessionId));
            presentation.setArticle(articleService.getArticle(articleId));
            return presentation;
        }).collect(Collectors.toList());
        sessionService.addConferencePresentationMany(preparedPresentations);
    }

    @RequestMapping(value="/conferences/{conferenceId}/sessions/{sessionId}/presentationsMany", method=RequestMethod.DELETE)
    public void deleteConferenceManyPresentation(@RequestBody List<Integer> presentationsIds) {
        sessionService.deleteConferencePresentationMany(presentationsIds);
    }
}
