package com.cms.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "articleID",nullable= false)
	private Article articleID;

	public Version() {
		
	}

    public Version(Integer versionID, Time  updateTime, String documentUrl, Integer vNumber, Article articleID ) {
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

	public Article getArticleID() {
		return articleID;
	}
    
}
