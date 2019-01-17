package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Attendance;
import com.cms.entity.Conference;
import com.cms.service.AttendanceService;

@CrossOrigin
@RestController
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@RequestMapping("/conferences/{conferenceId}/attendees")
	public List<Attendance> getAllAttendees(@PathVariable Conference conferenceId){
		return attendanceService.getAllAttendees(conferenceId);
	}
	
	@RequestMapping("/conferences/{conferenceId}/attendees/{role}")
	public List<Attendance> getAllAttendeesByRole(@PathVariable String role, @PathVariable Conference conferenceId){
		return attendanceService.getAllAttendeesByRole(role, conferenceId);
	}

}
