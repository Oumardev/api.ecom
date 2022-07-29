package com.ecom.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecom.api.models.Commentaire;
import com.ecom.api.repository.CommentaireRepository;

public class CommentaireService {
    
    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaire saveCommentaire(Commentaire commentaire){
        Commentaire commentaireSaved;

        commentaireSaved = commentaireRepository.save(commentaire);
        return commentaireSaved;
    }

    public Iterable<Commentaire> getAllCommentaire(){
        return commentaireRepository.findAll();
    }
}
