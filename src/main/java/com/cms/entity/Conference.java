package com.cms.entity;

import java.sql.Date;

import javax.persistence.*;

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

	@ManyToOne
	@JoinColumn(name = "organizerID", nullable = false)
    private User organizer;
	
	@Column(name="conferenceImg", nullable=true)
    private String conferenceImg;
	
	@Column(name="emergencyInfo", nullable=true)
    private String emergencyInfo;
	
	@Column(name="accomodationInfo", nullable=true)
    private String accomodationInfo;
	
	public Conference() {
		
	}

    public Conference(Integer conferenceID, String conferenceName, String description, Date startDate, Date finishDate,
			User organizer, String conferenceImg, String emergencyInfo, String accomodationInfo) {
		super();
		this.conferenceID = conferenceID;
		this.conferenceName = conferenceName;
		this.description = description;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.organizer = organizer;
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

	public User getOrganizer() {
		return organizer;
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
