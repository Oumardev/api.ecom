package com.ecom.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.models.Article;
import com.ecom.api.services.ArticleService;

@RestController
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public Optional<Article> getArticle(@PathVariable("id") final int id){
        return articleService.getArticle(id);
    }

    @GetMapping("/article")
    public Iterable<Article> getAllArticle(){
        return articleService.getAllArticle();
    }

    @DeleteMapping("/article")
    public void deleteArticle(@RequestBody Article article){
        articleService.deleteArticle(article);
    }

    @PostMapping("/article")
    public Article saveArticle(@RequestBody Article article){
        Article savedArticle;

        savedArticle = articleService.saveArticle(article);
        return savedArticle;
    }
}