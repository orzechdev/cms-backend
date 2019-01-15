package com.cms.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cms.controller.ArticleContainer;
import com.cms.entity.Article;
import com.cms.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

//    @PreAuthorize("hasAuthority('user')") TODO: think about authorization roles, and where to check them...
	public List<Article> getAllArticles() {
		List<Article> articles = new ArrayList<>();
		articleRepository.findAll().forEach(articles::add);
		return articles;
	}

	public Article getArticle(Integer articleId) {
		return articleRepository.findById(articleId).get();
	}

	public List<ArticleContainer> getAllArticleContainers() {
		List<ArticleContainer> articles = new ArrayList<>();
		for(Article a: articleRepository.findAll()) {
			articles.add(new ArticleContainer(a));
		}
		//articleRepository.findAll().forEach(articles::add);
		return articles;
	}

	public ArticleContainer getArticleContainer(Integer articleId) {
		return new ArticleContainer(articleRepository.findById(articleId).get());
	}

	public void addArticle(Article article) {
		articleRepository.save(article);
	}

	public Article addArticleFile(String fileName, User userAuthor) {
		return articleRepository.save(new Article(fileName, Calendar.getInstance().getTime(), userAuthor, false));
	}

	public void updateArticle(Article article) {
		articleRepository.save(article);
	}

	public void deleteArticle(Integer articleId) {
		articleRepository.deleteById(articleId);
	}

}
