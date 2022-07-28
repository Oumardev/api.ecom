package com.ecom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.models.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Integer> {
    
}
