package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Attendance;
import com.cms.entity.Conference;
import com.cms.entity.User;
import com.cms.repository.AttendanceRepository;
import com.cms.repository.UserRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	// Gets all attendees of a conference. Attendee means everyone independent of their role
//	public List<User> getAllAttendees(Conference conferenceId){
//		List<Integer> ids = new ArrayList<>();;
//		attendanceRepository.findAllByConferenceID(conferenceId).forEach(attendance ->
//				ids.add(attendance.getUserID().getId()));
//		return userRepository.findAllById(ids);
//	}
	
	// Gets all attendees of a conference by a specific role and returns as type List<User>
//	public List<User> getAllAttendeesByRole(String role, Conference conferenceId) {
//		List<Integer> ids = new ArrayList<>();
//		attendanceRepository.findAllByRoleAndConferenceID(role, conferenceId).forEach(attendance ->
//				ids.add(attendance.getUserID().getId()));
//		return userRepository.findAllById(ids);
//	}
	
	public List<Attendance> getAllAttendees(Conference conferenceId) {
		return attendanceRepository.findAllByConferenceID(conferenceId);
	}
	
	public List<Attendance> getAllAttendeesByRole(String role, Conference conferenceId){
		return attendanceRepository.findAllByRoleAndConferenceID(role, conferenceId);
	}

}
