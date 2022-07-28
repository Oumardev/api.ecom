package com.ecom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.models.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire,Integer> {
    
}
