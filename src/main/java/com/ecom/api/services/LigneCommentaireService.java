package com.ecom.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.api.models.LigneCommande;
import com.ecom.api.repository.LigneCommandeRepository;

import lombok.Data;

@Data
@Service
public class LigneCommentaireService {
    
    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public LigneCommande saveCommande(LigneCommande ligneCommande){
        LigneCommande ligneCommandeSaved;

        ligneCommandeSaved = ligneCommandeRepository.save(ligneCommande);
        return ligneCommandeSaved;
    }
}
