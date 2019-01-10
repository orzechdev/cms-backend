package com.cms.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Session", schema="dbo")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sessionID;
	
	@Column(name="conferenceID", nullable=false)
    private Integer conferenceID;
	
	@Column(name="chairName", nullable=false)
    private String chairName;
	
	@Column(name="datetime", nullable=false)
    private Time datetime;
	
	@Column(name="endtime", nullable=false)
    private Time endtime;

	@Column(name="name", nullable=false)
    private String name;
	
	public Session() {
		
	}

    public Session(Integer sessionID, Integer conferenceID, String chairName, Time datetime, Time endtime, String name)
    {
		super();
		this.sessionID = sessionID;
		this.conferenceID = conferenceID;
		this.chairName = chairName;
		this.datetime = datetime;
		this.endtime = endtime;
		this.name = name;

	}

	public long getsessionID() {
		return sessionID;
	}

	public String getName() {
		return name;
	}

	public Integer getConferenceID() {
		return conferenceID;
	}

	public Time getDatetime() {
		return datetime;
	}

	public Time getEndtime() {
		return endtime;
	}

	public String getChairName() {
		return chairName;
	}

    
	
	
	
}
