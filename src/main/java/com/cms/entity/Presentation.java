package com.cms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Presentation", schema="dbo")

public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer presentationID;
	
	@Column(name="startTime", nullable=false)
    private Date startTime;
	
	@Column(name="endTime", nullable=false)
    private Date endTime;
	
	@Column(name="room", nullable=false)
    private String room;
	
	@Column(name="description", nullable=true)
    private String description;

	@Column(name="presentationName", nullable=false)
    private String presentationName;
	
	@Column(name="presenterName", nullable=true)
    private String presenterName;
	
	@Column(name="sessionID", nullable=true)
    private Integer sessionID;
	
	@Column(name="articleID", nullable=true)
    private Integer articleID;
	
	public Presentation() {
		
	}

    public Presentation(Integer presentationID, Date startTime, Date endTime, String room, String description, String presentationName, String presenterName, Integer sessionID, Integer articleID ) {
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

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public String getRoom() {
		return room;
	}

	public String getPresenterName() {
		return presenterName;
	}

	public Integer getSessionID() {
		return sessionID;
	}

	public Integer getArticleID() {
		return articleID;
	}
    
}
