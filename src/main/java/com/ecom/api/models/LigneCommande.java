package com.ecom.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LigneCommande")
public class LigneCommande {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommande;

    private int idUser;

    private int idArticle;

    private String date;

    private int nbArticle;

    private Float TVA;
}
