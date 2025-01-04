package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Candidat")
@Table(name = "candidat")
@PrimaryKeyJoinColumn(name = "id_candidat", referencedColumnName = "id_utilisateur")
@Getter
@Setter
public class Candidat extends Utilisateur {


    @Column(name = "parti", nullable = false, length = 100)
    private String parti;

    @Column(name = "programme")
    private String programme;

    @Column(name = "biographie")
    private String biographie;

}