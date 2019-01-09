package com.cms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Article;
import com.cms.service.ArticleService;

@CrossOrigin
@RestController
public class ArticlesController {

	@Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<Article> articles() {
        return articleService.getAllArticles();
    }
    
    @RequestMapping("/articles/{articleId}")
    public Article getArticle(@PathVariable Integer articleId) {
    	return articleService.getArticle(articleId);   	
    }
    
    @RequestMapping(value="/articles", method=RequestMethod.POST)
    public void addArticle(@RequestBody Article article) {
    	articleService.addArticle(article); 	
    }
    
    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.PUT)
    public void updateArticle(@RequestBody Article article) {
    	articleService.updateArticle(article);
    }
    
    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.DELETE)
    public void deleteArticle(@PathVariable Integer articleId) {
    	articleService.deleteArticle(articleId);
    }
    
    
    
}