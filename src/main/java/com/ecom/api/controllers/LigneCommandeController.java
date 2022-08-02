package com.ecom.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.errors.ApiRequestException;
import com.ecom.api.models.LigneCommande;
import com.ecom.api.services.LigneCommandeService;

@RestController
public class LigneCommandeController {
    
    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping("/lignecommande/{id}")
    public ResponseEntity<?> getLigneCommande(@PathVariable("id") final int id){
        LigneCommande saveLigneCommande = ligneCommandeService.getLigneCommande(id)
        .orElseThrow(()->new ApiRequestException("Cette commande n'existe pas"));

        return ResponseEntity.ok(saveLigneCommande);
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
