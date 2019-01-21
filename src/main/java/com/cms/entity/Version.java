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
    private Integer verNumber;
	
	@ManyToOne
	@JoinColumn(name = "articleID",nullable= false)
	private Article article;

	public Version() {
		
	}

	public Version(Date updateTime, String documentUrl, Integer verNumber, Article article ) {
		super();
		this.updateTime = updateTime;
		this.documentUrl = documentUrl;
		this.verNumber = verNumber;
		this.article = article;
	}

    public Version(Integer versionID, Time updateTime, String documentUrl, Integer vNumber, Article article ) {
		super();
		this.versionID = versionID;
		this.updateTime = updateTime;
		this.documentUrl = documentUrl;
		this.verNumber = verNumber;
		this.article = article;
	}

	public Integer getVersionID() {
		return versionID;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public Integer getVerNumber() {
		return verNumber;
	}

	public Article getArticle() {
		return article;
	}
    
}
