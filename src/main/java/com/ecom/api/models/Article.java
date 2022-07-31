package com.ecom.api.models;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "Articles")
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Float prixUnitaire;

    @Column(nullable = false)
    private String libelle;

    @JsonBackReference
    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Commentaire> commentaires;
}
