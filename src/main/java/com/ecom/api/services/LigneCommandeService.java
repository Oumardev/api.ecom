package com.ecom.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.models.LigneCommande;
import com.ecom.api.repository.LigneCommandeRepository;

import lombok.Data;

@Data
@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public Optional<LigneCommande> getLigneCommande(final int id){
        return ligneCommandeRepository.findById(id);
    }

    public Iterable<LigneCommande> getAllLigneCommande(){
        return ligneCommandeRepository.findAll();
    }

    public void deleteLigneCommande(LigneCommande ligneCommande){
        ligneCommandeRepository.delete(ligneCommande);
    }

    public LigneCommande saveLigneCommande(LigneCommande ligneCommande){
        LigneCommande savedLigneCommande;

        savedLigneCommande = ligneCommandeRepository.save(ligneCommande);
        return savedLigneCommande;
    }
}
