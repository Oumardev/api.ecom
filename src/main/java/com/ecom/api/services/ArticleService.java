package com.ecom.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.models.Article;
import com.ecom.api.repository.ArticleRepository;

import lombok.Data;

@Data
@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticle(final int id){
        return articleRepository.findById(id).get();
    }

    public Iterable<Article> getAllArticle(){
        return articleRepository.findAll();
    }

    public void deleteArticle(Article article){
        articleRepository.delete(article);
    }

    public Article saveArticle(Article article){
        Article savedArticle;

        savedArticle = articleRepository.save(article);

        return savedArticle;
    }
}
