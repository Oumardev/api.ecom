package com.ecom.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.models.LigneCommande;
import com.ecom.api.services.LigneCommandeService;

@RestController
public class LigneCommandeController {
    
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping("/lignecommande/{id}")
    public Optional<LigneCommande> getLigneCommande(@PathVariable("id") final int id){

        return ligneCommandeService.getLigneCommande(id);
    } 

    @GetMapping("/lignecommande")
    public Iterable<LigneCommande> getAllLigneCommande(){
        return ligneCommandeService.getAllLigneCommande();
    }

    @DeleteMapping("/lignecommande")
    public void deleteLigneCommande(@RequestBody LigneCommande ligneCommande){
        ligneCommandeService.deleteLigneCommande(ligneCommande);
    }

    @PostMapping("/lignecommande")
    public LigneCommande saveLigneCommande(@RequestBody LigneCommande ligneCommande){
        LigneCommande savedLigneCommande;

        savedLigneCommande = ligneCommandeService.saveLigneCommande(ligneCommande);
        return savedLigneCommande;
    }
}
