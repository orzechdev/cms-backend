
package com.cms.entity;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "Review", schema="dbo")
public class Review {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewID;

	@Column(nullable = false)
	private Integer articleID;
	
	@Column(nullable = false)
	private BigDecimal grade;
	
	private String comment;

	@ManyToOne
	@JoinColumn(name = "userID",nullable= false)
	private User user;

	public Review(){
	}

	public Review(Integer articleID) {
		this.articleID = articleID;
	}

	public Integer getReviewID() {
		return reviewID;
	}

	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	


}
