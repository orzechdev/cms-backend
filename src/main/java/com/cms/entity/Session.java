package com.cms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Session", schema="dbo")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sessionID;
	
	@ManyToOne
	@JoinColumn(name = "conferenceID",nullable= false)
	private Conference conference;
	
	@Column(name="chairName", nullable=false)
    private String chairName;

	@Column(name="startDateTime", nullable=false)
	private Timestamp startDateTime;

	@Column(name="endDateTime", nullable=false)
	private Timestamp endDateTime;

	@Column(name="name", nullable=false)
    private String name;
	
	public Session() {
		
	}

    public Session(Integer sessionID, Conference conference, String chairName, Timestamp startDateTime, Timestamp endDateTime, String name)
    {
		super();
		this.sessionID = sessionID;
		this.conference = conference;
		this.chairName = chairName;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.name = name;

	}
    
	public long getSessionID() {
		return sessionID;
	}

	public String getName() {
		return name;
	}

	public Conference getConference() {
		return conference;
	}

	public String getChairName() {
		return chairName;
	}

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }
}
