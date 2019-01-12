
package com.cms.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Article", schema="dbo")
public class Article {


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer articleID;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	@ManyToOne
	@JoinColumn(name = "userAuthorID",nullable= false)
	private User userAuthor;

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

	public User getUserAuthor() {
		return userAuthor;
	}

	public void setUserAuthor(User userAuthor) {
		this.userAuthor = userAuthor;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/*
	public int getUserAuthorID() {
		return userAuthorID;
	}

	public void setUserAuthorID(int userAuthorID) {
		this.userAuthorID = userAuthorID;
	}
	*/

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public Article() {

	}

	public Article(Integer articleID, String name, Date publishDate, User userAuthor, boolean isAccepted) {
		this.articleID = articleID;
		this.name = name;
		this.publishDate = publishDate;
		this.userAuthor = userAuthor;
		this.isAccepted = isAccepted;
	}
}
