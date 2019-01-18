
package com.cms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cms.entity.Attendance;




public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {
	List<Attendance> findByConferenceID_ConferenceID(Integer conferenceId);
}
