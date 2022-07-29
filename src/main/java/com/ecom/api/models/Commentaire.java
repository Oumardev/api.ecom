package com.ecom.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Commentaire")
public class Commentaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentaire;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article idArticle;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String text;
}
