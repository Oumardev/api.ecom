package com.ecom.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Articles")
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticle;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Float prixUnitaire;

    @Column(nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "idArticle")
    private List<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "idArticle")
    private List<Commentaire> commentaires;
}
