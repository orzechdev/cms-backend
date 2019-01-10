
package com.cms.controller;
import java.util.List;

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
    private SessionService sessionService;

    @RequestMapping("/sessions")
    public List<Session> sessions() {
        return sessionService.getAllSessions();
    }
    
    @RequestMapping("/sessions/{sessionId}")
    public Session getSession(@PathVariable Integer sessionId) {
    	return sessionService.getSession(sessionId);   	
    }
    
    @RequestMapping(value="/sessions", method=RequestMethod.POST)
    public void addSession(@RequestBody Session session) {
    	sessionService.addSession(session); 	
    }
    
    @RequestMapping(value="/sessions/{sessionId}", method=RequestMethod.PUT)
    public void updateSession(@RequestBody Session session) {
    	sessionService.updateSession(session);
    }
    
    @RequestMapping(value="/sessions/{sessionId}", method=RequestMethod.DELETE)
    public void deleteSession(@PathVariable Integer sessionId) {
    	sessionService.deleteSession(sessionId);
    }
    
    
    
}
