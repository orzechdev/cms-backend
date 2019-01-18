package com.cms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Attendance;
import com.cms.entity.Session;
import com.cms.service.AttendanceService;



@CrossOrigin
@RestController
public class AttendanceController {

	@Autowired
    private AttendanceService attendanceService;

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
    
    @RequestMapping("/conferences/{conferenceId}/attendance/user/{userId}")
    public Attendance userAttendance(@PathVariable Integer conferenceId,@PathVariable Integer userId) {
        return attendanceService.getAttendance(conferenceId, userId);
    }
    
    @RequestMapping("/conferences/{conferenceId}/role/user/{userId}")
    public String userRole(@PathVariable Integer conferenceId,@PathVariable Integer userId) {
        return attendanceService.getAttendance(conferenceId, userId).getRole();
    }
    
    
}