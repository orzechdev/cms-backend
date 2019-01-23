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
	private Session session;
	
	@ManyToOne
	@JoinColumn(name = "articleID",nullable= false)
	private Article article;
	
	public Presentation() {
		
	}

    public Presentation(Integer presentationID, Time startTime, Time endTime, String room, String description, String presentationName, String presenterName, Session session, Article article ) {
		super();
		this.presentationID = presentationID;
		this.presentationName = presentationName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.presenterName = presenterName;
		this.session = session;
		this.article = article;
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

	public Session getSession() {
		return session;
	}

	public Article getArticle() {
		return article;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getPresentationID() {
		return presentationID;
	}

	public void setPresentationID(Integer presentationID) {
		this.presentationID = presentationID;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPresentationName() {
		return presentationName;
	}

	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}

	public void setPresenterName(String presenterName) {
		this.presenterName = presenterName;
	}
}
