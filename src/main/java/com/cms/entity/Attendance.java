package com.cms.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance", schema="dbo")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer AttendanceID;
	
	@ManyToOne
	@JoinColumn(name = "conferenceID",nullable= false)
	private Conference conferenceID;
	
	@ManyToOne
	@JoinColumn(name = "userID",nullable= false)
	private User userID;
	
	@Column(name="attendance", nullable=false)
    private boolean attendance;

	@Column(name="role", nullable=false)
    private String role;
	
	public Attendance() {
		
	}

    public Attendance(Integer AttendanceID, Conference conferenceID, User userID, boolean attendance, String role)
    {
		super();
		this.AttendanceID = AttendanceID;
		this.conferenceID = conferenceID;
		this.userID = userID;
		this.attendance = attendance;
		this.role = role;

	}

	public long getAttendanceID() {
		return AttendanceID;
	}

	public String getRole() {
		return role;
	}

	public Conference getConferenceID() {
		return conferenceID;
	}

	public User getUserID() {
		return userID;
	}

	public boolean getAttendance() {
		return attendance;
	}

    
	
}
