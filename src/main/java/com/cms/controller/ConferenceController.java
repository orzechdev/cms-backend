package com.cms.controller;
import java.util.List;

import com.cms.entity.Article;
import com.cms.entity.Presentation;
import com.cms.entity.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Conference;
import com.cms.service.ConferenceService;

@CrossOrigin
@RestController
public class ConferenceController {

	@Autowired
    private ConferenceService conferenceService;

    @RequestMapping("/conferences")
    public List<Conference> conferences() {
        return conferenceService.getAllConferences();
    }
    
    @RequestMapping("/conferences/{conferenceId}")
    public Conference getConference(@PathVariable Integer conferenceId) {
    	return conferenceService.getConference(conferenceId);   	
    }
    
    @RequestMapping(value="/conferences", method=RequestMethod.POST)
    public void addConference(@RequestBody Conference conference) {
    	conferenceService.addConference(conference); 	
    }
    
    @RequestMapping(value="/conferences/{conferenceId}", method=RequestMethod.PUT)
    public void updateConference(@RequestBody Conference conference) {
    	conferenceService.updateConference(conference);
    }
    
    @RequestMapping(value="/conferences/{conferenceId}", method=RequestMethod.DELETE)
    public void deleteConference(@PathVariable Integer conferenceId) {
    	conferenceService.deleteConference(conferenceId);
    }
    
    @RequestMapping("/conferences/{conferenceId}/presentations")
    public List<Presentation> getConferencePresentations(@PathVariable Integer conferenceId) {
        return conferenceService.getConferencePresentations(conferenceId);
    }
/* NOTE: This would show only articles assigned to presentations
    @RequestMapping("/conferences/{conferenceId}/articles")
    public List<Article> getConferenceArticles(@PathVariable Integer conferenceId) {
        return conferenceService.getConferenceArticles(conferenceId);
    }
    
    */
    @RequestMapping("/conferences/{conferenceId}/articlesVersions")
    public List<Version> getConferenceArticlesVersions(@PathVariable Integer conferenceId) {
        return conferenceService.getConferenceArticlesVersions(conferenceId);
    }



}
