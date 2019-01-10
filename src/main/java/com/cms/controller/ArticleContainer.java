
package com.cms.controller;

import java.util.Date;


import com.cms.entity.Article;

public class ArticleContainer {

	
    private Integer articleID;
	private String name;
	private Date publishDate;
	private String authorName;
	private boolean isAccepted;

	public ArticleContainer(Article article) {
		articleID=article.getArticleID();
		name=article.getName();
		publishDate=article.getPublishDate();
		isAccepted=article.isAccepted();
		authorName=article.getUserAuthor().getUsername();
	}

	public Integer getArticleID() {
		return articleID;
	}

	public String getName() {
		return name;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public boolean isAccepted() {
		return isAccepted;
	}
	


}
