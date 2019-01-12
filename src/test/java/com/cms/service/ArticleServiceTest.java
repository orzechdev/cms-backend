package com.cms.service;

import com.cms.controller.ArticleContainer;
import com.cms.entity.Article;
import com.cms.entity.User;
import com.cms.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import(ArticleServiceTestContextConfiguration.class)
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;
    @MockBean
    private ArticleRepository articleRepository;

    private List<Article> testArticles = new ArrayList<>();

    private List<ArticleContainer> testArticleContainers = new ArrayList<>();

    @Before
    public void setUp() {
        User testAuthor = new User(
                "test-username",
                "TestPassword",
                "Jan",
                "Kowalski",
                "test@test.test",
                123456789
        );
        testArticles.add(new Article(0, "Test1", new Date(0), testAuthor, false));
        testArticles.add(new Article(1, "Test2", new Date(100), testAuthor, false));
        testArticles.add(new Article(2, "Test3", new Date(3000), testAuthor, false));

        for (Article article : testArticles) {
            testArticleContainers.add(new ArticleContainer(article));
        }

        Mockito.when(articleRepository.findAll()).thenReturn(testArticles);
        Mockito.when(articleRepository.findById(0)).thenReturn(Optional.of(testArticles.get(0)));
        Mockito.when(articleRepository.findById(1)).thenReturn(Optional.of(testArticles.get(1)));
        Mockito.when(articleRepository.findById(2)).thenReturn(Optional.of(testArticles.get(2)));
    }

    @Test
    public void getAllArticlesTest() {
        List<Article> articles = articleService.getAllArticles();

        assertEquals(testArticles, articles);
    }

    @Test
    public void getArticleTest() {
        Article article0 = articleService.getArticle(0);
        Article article1 = articleService.getArticle(1);
        Article article2 = articleService.getArticle(2);

        assertEquals(testArticles.get(0), article0);
        assertEquals(testArticles.get(1), article1);
        assertEquals(testArticles.get(2), article2);
    }

    @Test
    public void getAllArticleContainersTest() {
        List<ArticleContainer> articleContainers = articleService.getAllArticleContainers();

        assertEquals(testArticleContainers, articleContainers);
    }

    @Test
    public void getArticleContainerTest() {
        ArticleContainer articleContainer0 = articleService.getArticleContainer(0);
        ArticleContainer articleContainer1 = articleService.getArticleContainer(1);
        ArticleContainer articleContainer2 = articleService.getArticleContainer(2);

        assertEquals(testArticleContainers.get(0), articleContainer0);
        assertEquals(testArticleContainers.get(1), articleContainer1);
        assertEquals(testArticleContainers.get(2), articleContainer2);
    }

    @Test
    public void addArticleTest() {
        articleService.addArticle(testArticles.get(0));

        Mockito.verify(articleRepository).save(testArticles.get(0));
    }

    @Test
    public void updateArticleTest() {
        articleService.updateArticle(testArticles.get(0));

        Mockito.verify(articleRepository).save(testArticles.get(0));
    }

    @Test
    public void deleteArticleTest() {
        articleService.deleteArticle(0);

        Mockito.verify(articleRepository).deleteById(0);
    }
}

@TestConfiguration
class ArticleServiceTestContextConfiguration {
    @Bean
    public ArticleService articleService() {
        return new ArticleService();
    }
}