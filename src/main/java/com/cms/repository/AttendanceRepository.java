
package com.cms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.cms.entity.Attendance;
import com.cms.entity.Conference;

public interface AttendanceRepository extends CrudRepository<Attendance,Integer> {
	public List<Attendance> findAllByRoleAndConferenceID(String role, Conference conferenceId);
	public List<Attendance> findAllByConferenceID(Conference conferenceId);
}
