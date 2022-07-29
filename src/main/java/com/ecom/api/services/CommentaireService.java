package com.ecom.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.models.Commentaire;
import com.ecom.api.repository.CommentaireRepository;

import lombok.Data;

@Data
@Service
public class CommentaireService {
    
    @Autowired
    private CommentaireRepository commentaireRepository;

    public Optional<Commentaire> getCommentaire(final int id){
        return commentaireRepository.findById(id);
    }

    public Iterable<Commentaire> getAllCommentaire(){
        return commentaireRepository.findAll();
    }

    public void deleteCommentaire(Commentaire commentaire){
        commentaireRepository.delete(commentaire);
    }

    public Commentaire saveCommentaire(Commentaire commentaire){
        Commentaire savedCommentaire;

        savedCommentaire = commentaireRepository.save(commentaire);
        return savedCommentaire;
    }

}
