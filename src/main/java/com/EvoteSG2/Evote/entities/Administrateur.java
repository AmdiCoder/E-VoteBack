package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "administrateur")
// Utilisé pour identifier cette entité dans la table parente dans le contexte d'héritage.
@DiscriminatorValue("Admin")
// Définit la clé primaire de cette entité et la relie à la clé primaire de la classe parent (Utilisateur).
@PrimaryKeyJoinColumn(name = "id_admin", referencedColumnName = "id_utilisateur")
@Getter
@Setter

//Classe fille Administrateur qui etend la classe mere Utilisateur
public class Administrateur extends Utilisateur{

    @Column(name = "matricule", nullable = false, length = 50)
    private String matricule;
}