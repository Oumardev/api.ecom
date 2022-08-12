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

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Username est obligatoire")
    @Size(max = 10,min = 2,message = "Username doit etre compris entre 2 et 10 caractères")
    private String username;

    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;

    @NotNull(message = "Le role est obligatoire")
    private String role;

    @NotNull(message = "La date de naissance est obligatoire")
    private Date dateNaissance;

    @NotNull(message = "Le numéro de téléphone est obligatoire")
    private String telephone;

    @Value("${some.key:true}")
    private boolean enabled;    

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Collection<Commentaire> commentaires;

    
}
