package com.EvoteSG2.Evote.entities;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "utilisateur", schema = "evote_db", indexes = {
        @Index(name = "idx_user_numero_carte", columnList = "numero_carte"),
        @Index(name = "idx_user_role", columnList = "role")
}, uniqueConstraints = {
        @UniqueConstraint(name = "numero_carte", columnNames = {"numero_carte"})
})
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false)
    private Integer id;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "numero_carte", nullable = false, length = 50)
    private String numeroCarte;

    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "date_creation")
    private Instant dateCreation;


    
    /* 
    // Méthode qui hache le mot de passe avant d'enregistrer l'utilisateur
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = hashPassword(motDePasse);
    }

    // Méthode pour hacher le mot de passe
    private String hashPassword(String motDePasse) {
        return BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }

    // Initialiser la date de création si elle est nulle
    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.dateCreation)) {
            this.dateCreation = Instant.now();
        }
    }*/

    public Utilisateur(Integer id, String prenom, String nom, LocalDate dateNaissance, String numeroCarte,
            String telephone, String role, String email, String motDePasse, Instant dateCreation) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.numeroCarte = numeroCarte;
        this.telephone = telephone;
        this.role = role;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateCreation = dateCreation;
    }

    public Utilisateur() {
    }

}