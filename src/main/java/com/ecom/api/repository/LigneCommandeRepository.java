package com.ecom.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.api.models.LigneCommande;

@Repository
public interface LigneCommandeRepository extends CrudRepository<LigneCommande,Integer> {
    
}
