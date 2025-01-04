package com.EvoteSG2.Evote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Définit cette classe comme une entité JPA
@Entity
// Entité JPA reliée à la table "utilisateur".
@Table(name = "utilisateur")
// Indique une stratégie d'héritage JOINED (tables séparées pour chaque classe fille).
@Inheritance(strategy = InheritanceType.JOINED)
// Utilisé pour différencier les classes filles dans la hiérarchie avec une colonne "role".
@DiscriminatorColumn(name = "role")
// Génère automatiquement les getters et setters pour tous les champs grâce à Lombok.
@Getter
@Setter
public class Utilisateur {

    @Id // Indique que ce champ est la clé primaire de l'entité.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clé est générée automatiquement par la base de données.
    @Column(name = "id_utilisateur") // Mappe le champ à la colonne "id_utilisateur" dans la table.
    private Long idUtilisateur;

    // Définit la colonne "prenom" comme obligatoire (non nullable) avec une longueur maximale de 100 caractères
    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "date_naissance")
    // Gère le formatage de la date au format "jj/MM/aaaa" lors des conversions JSON
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateNaissance;

    @Column(name ="sexe",nullable = false,length = 1)
    private String sexe;

    // La colonne "numero_carte" est obligatoire, doit être unique
    @Column(name = "numero_carte", unique = true, nullable = false, length = 50)
    private String numeroCarte;

    @Column(name = "telephone", unique = true, nullable = false, length = 20)
    private String telephone;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "date_creation")
    // Initialise automatiquement ce champ à l'heure actuelle lors de la création de l'entité.
    private LocalDateTime dateCreation = LocalDateTime.now();

}
