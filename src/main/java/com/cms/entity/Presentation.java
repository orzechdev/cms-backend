package com.cms.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Presentation", schema="dbo")

public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer presentationID;
	
	@Column(name="startTime", nullable=false)
    private Time startTime;
	
	@Column(name="endTime", nullable=false)
    private Time endTime;
	
	@Column(name="room", nullable=false)
    private String room;
	
	@Column(name="description", nullable=true)
    private String description;

	@Column(name="presentationName", nullable=false)
    private String presentationName;
	
	@Column(name="presenterName", nullable=true)
    private String presenterName;
	
	@ManyToOne
	@JoinColumn(name = "sessionID",nullable= false)
	private Session sessionID;
	
	@ManyToOne
	@JoinColumn(name = "articleID",nullable= false)
	private Article articleID;
	
	public Presentation() {
		
	}

    public Presentation(Integer presentationID, Time startTime, Time endTime, String room, String description, String presentationName, String presenterName, Session sessionID, Article articleID ) {
		super();
		this.presentationID = presentationID;
		this.presentationName = presentationName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.presenterName = presenterName;
		this.sessionID = sessionID;
		this.articleID = articleID;
	}

	public long getpresentationID() {
		return presentationID;
	}

	public String getpresentationName() {
		return presentationName;
	}

	public String getDescription() {
		return description;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public String getRoom() {
		return room;
	}

	public String getPresenterName() {
		return presenterName;
	}

	public Session getSessionID() {
		return sessionID;
	}

	public Article getArticleID() {
		return articleID;
	}
    
}
