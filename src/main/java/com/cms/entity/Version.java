package com.cms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Version", schema="dbo")

public class Version {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer versionID;
	
	@Column(name="updateTime", nullable=false)
    private Date updateTime;
	
	@Column(name="documentUrl", nullable=false)
    private String documentUrl;
	
	@Column(name="vNumber", nullable=false)
    private Integer vNumber;
	
	@Column(name="articleID", nullable=false)
    private Integer articleID;
	
	public Version() {
		
	}

    public Version(Integer versionID, Date  updateTime, String documentUrl, Integer vNumber, Integer articleID ) {
		super();
		this.versionID = versionID;
		this.updateTime = updateTime;
		this.documentUrl = documentUrl;
		this.vNumber = vNumber;
		this.articleID = articleID;
	}

	public long getversionID() {
		return versionID;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public Integer getVNumber() {
		return vNumber;
	}

	public Integer getArticleID() {
		return articleID;
	}
    
}
