
package com.cms.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Article", schema="dbo")
public class ArticleTable {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer articleID;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Column(nullable = false)
	private int userAuthorID;
	
	private boolean isAccepted;

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getUserAuthorID() {
		return userAuthorID;
	}

	public void setUserAuthorID(int userAuthorID) {
		this.userAuthorID = userAuthorID;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	


}
