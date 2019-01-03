package com.cms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Conference", schema="dbo")
public class Conference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer conferenceID;
	
	@Column(name="conferenceName", nullable=false)
    private String conferenceName;
	
	@Column(name="description", nullable=true)
    private String description;
	
	@Column(name="startDate", nullable=false)
    private Date startDate;
	
	@Column(name="finishDate", nullable=false)
    private Date finishDate;
	
	@Column(name="organizerID", nullable=false)
    private Integer organizerID;
	
	@Column(name="conferenceImg", nullable=true)
    private String conferenceImg;
	
	@Column(name="emergencyInfo", nullable=true)
    private String emergencyInfo;
	
	@Column(name="accomodationInfo", nullable=true)
    private String accomodationInfo;
	
	public Conference() {
		
	}

    public Conference(Integer conferenceID, String conferenceName, String description, Date startDate, Date finishDate,
			Integer organizerID, String conferenceImg, String emergencyInfo, String accomodationInfo) {
		super();
		this.conferenceID = conferenceID;
		this.conferenceName = conferenceName;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.organizerID = organizerID;
		this.conferenceImg = conferenceImg;
		this.emergencyInfo = emergencyInfo;
		this.accomodationInfo = accomodationInfo;
	}

	public long getConferenceID() {
		return conferenceID;
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public long getOrganizerID() {
		return organizerID;
	}

	public String getConferenceImg() {
		return conferenceImg;
	}

	public String getEmergencyInfo() {
		return emergencyInfo;
	}

	public String getAccomodationInfo() {
		return accomodationInfo;
	}
    
}
