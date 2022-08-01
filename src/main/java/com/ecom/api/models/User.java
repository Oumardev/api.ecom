package com.ecom.api.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le nom est obligatoire")
    @Size(max = 20,min = 2,message = "Le nom doit etre compris entre 2 et 20 caractères")
    private String nom;

    @NotNull(message = "La date de naissance est obligatoire")
    private String dateNaissance;

    @NotNull(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Collection<Commentaire> commentaires;
}
