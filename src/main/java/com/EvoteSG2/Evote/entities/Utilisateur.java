package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "utilisateur", schema = "evote_db", indexes = {
        @Index(name = "idx_user_numero_carte", columnList = "numero_carte"),
        @Index(name = "idx_user_role", columnList = "role")
}, uniqueConstraints = {
        @UniqueConstraint(name = "numero_carte", columnNames = {"numero_carte"})
})
public class
Utilisateur {
    @Id
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

}