package com.ecom.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.exception.ApiRequestException;
import com.ecom.api.models.Commentaire;
import com.ecom.api.services.CommentaireService;

@RestController
public class CommentaireController {
    
    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/commentaire/{id}")
    public ResponseEntity<Commentaire> getCommentaire(@PathVariable("id") final int id){
        Commentaire commentaire = commentaireService.getCommentaire(id)
        .orElseThrow(()-> new ApiRequestException("Le commentaire avec l'id: "+id+" n'existe pas"));

        return ResponseEntity.ok(commentaire);
    }

    @GetMapping("/commentaire")
    public Iterable<Commentaire> getAllCommentaire(){
        return commentaireService.getAllCommentaire();
    }

    @DeleteMapping("/commentaire")
    public void deleteCommentaire(@RequestBody Commentaire commentaire){
        commentaireService.deleteCommentaire(commentaire);
    }

    @PostMapping(value = "/commentaire", consumes = MediaType.APPLICATION_JSON_VALUE,produces = "application/json")
    public Commentaire saveCommentaire(@RequestBody Commentaire commentaire){
       
        Commentaire saved = commentaireService.saveCommentaire(commentaire);
        return saved;
    }
}
