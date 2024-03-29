package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Attendance;
import com.cms.repository.AttendanceRepository;


@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

//    @PreAuthorize("hasAuthority('user')") TODO: think about authorization roles, and where to check them...
	public List<Attendance> getAllAttendances() {
		List<Attendance> attendances = new ArrayList<>();
		attendanceRepository.findAll().forEach(attendances::add);
		return attendances;
	}
	
	public List<Attendance> getAllAttendances(Integer conferenceID) {
		List<Attendance> attendances = new ArrayList<>();
		attendanceRepository.findByConferenceID_ConferenceID(conferenceID).forEach(attendances::add);
		return attendances;
	}

	public Attendance getAttendance(Integer attendanceId) {
		return attendanceRepository.findById(attendanceId).get();
	}
	
	public List<Attendance> getAttendance(Integer attendanceId, Integer userId) {
		return attendanceRepository.findByConferenceID_ConferenceIDAndUserID_id(attendanceId,userId);
	}

	public void addAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}
	
	public void updateAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}

	public void deleteAttendance(Integer attendanceId) {
		attendanceRepository.deleteById(attendanceId);		
	}

}
