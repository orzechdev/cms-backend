package com.cms.controller;
import java.util.ArrayList;
import java.util.List;

import com.cms.principal.AppUserPrincipal;
import com.cms.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Attendance;
import com.cms.service.AttendanceService;



@CrossOrigin
@RestController
public class AttendanceController {

	@Autowired
    private AttendanceService attendanceService;

	@Autowired
    private ConferenceService conferenceService;

    @RequestMapping("/attendances")
    public List<Attendance> attendances() {
        return attendanceService.getAllAttendances();
    }
    
    @RequestMapping("/attendances/{attendanceId}")
    public Attendance getAttendance(@PathVariable Integer attendanceId) {
    	return attendanceService.getAttendance(attendanceId);   	
    }

    @RequestMapping(value="/attendancess", method=RequestMethod.POST)
    public void addAttendance(@RequestBody Attendance attendance) {
    	attendanceService.addAttendance(attendance);
    }
    @RequestMapping(value="/attendanceUserAttend/{conferenceId}", method=RequestMethod.POST)
    public void addAttendance(@AuthenticationPrincipal AppUserPrincipal userPrincipal, @RequestBody Attendance attendance, @PathVariable Integer conferenceId) {
        Integer attId = attendance.getAttendanceID();
        Attendance attendanceEnd;
        if (attId == null) {
            attendanceEnd = attendance;
            attendanceEnd.setUserID(userPrincipal.getUser());
            attendanceEnd.setConferenceID(conferenceService.getConference(conferenceId));
        } else {
            attendanceEnd = attendanceService.getAttendance(attId);
            attendanceEnd.setAttendance(attendance.getAttendance());
        }
        attendanceService.addAttendance(attendanceEnd);
    }
    
    @RequestMapping(value="/attendances/{attendanceId}", method=RequestMethod.PUT)
    public void updateAttendance(@RequestBody Attendance attendance) {
    	attendanceService.updateAttendance(attendance);
    }
    
    @RequestMapping(value="/attendances/{attendanceId}", method=RequestMethod.DELETE)
    public void deleteAttendance(@PathVariable Integer attendanceId) {
    	attendanceService.deleteAttendance(attendanceId);
    }
    
    @RequestMapping("/conferences/{conferenceId}/attendances")
    public List<Attendance> attendances(@PathVariable Integer conferenceId) {
        return attendanceService.getAllAttendances(conferenceId);
    }
    
    @RequestMapping("/conferences/{conferenceId}/attendance/user")
    public List<Attendance> userAttendance(@AuthenticationPrincipal AppUserPrincipal userPrincipal, @PathVariable Integer conferenceId) {
        if (userPrincipal != null) {
            return attendanceService.getAttendance(conferenceId, userPrincipal.getId());
        } else {
            return null;
        }
    }
    
    @RequestMapping("/conferences/{conferenceId}/role/user")
    public List<String> userRole(@AuthenticationPrincipal AppUserPrincipal userPrincipal, @PathVariable Integer conferenceId) {
        if (userPrincipal != null) {
            List<String> roles = new ArrayList<String>();
            for (Attendance a : attendanceService.getAttendance(conferenceId, userPrincipal.getId())) {
                roles.add(a.getRole());
            }
            return roles;
        } else {
            return null;
        }
    }
    
    
}