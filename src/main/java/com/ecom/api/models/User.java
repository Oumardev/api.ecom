package com.ecom.api.models;

import java.sql.Date;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le login est obligatoire")
    @Size(max = 10,min = 2,message = "Le login doit etre compris entre 2 et 10 caractères")
    private String login;

    @NotNull(message = "La date de naissance est obligatoire")
    private Date dateNaissance;

    @NotNull(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Collection<Commentaire> commentaires;
}
