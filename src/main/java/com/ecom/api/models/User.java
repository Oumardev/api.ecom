package com.ecom.api.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String nom;

    private String dateNaissance;

    private String telephone;

    @OneToMany(mappedBy = "idUser")
    private List<LigneCommande> ligneCommandes;

    @OneToMany(mappedBy = "idUser")
    private List<Commentaire> commentaires;
}
