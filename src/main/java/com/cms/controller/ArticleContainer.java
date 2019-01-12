
package com.cms.controller;

import java.util.Date;
import java.util.Objects;


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
		authorName=article.getUserAuthor().getFirstName()+" "+article.getUserAuthor().getLastName();
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArticleContainer that = (ArticleContainer) o;
		return articleID.equals(that.articleID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleID);
	}
}
