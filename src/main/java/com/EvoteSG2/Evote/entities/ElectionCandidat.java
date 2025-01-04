package com.EvoteSG2.Evote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

//Entité représentant la relation entre une élection et ses candidats.
//Chaque instance de cette classe correspond à un candidat inscrit à une élection spécifique.
@Entity
@Table(name = "election_candidat")
@Getter
@Setter
@NoArgsConstructor
public class ElectionCandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_election_candidat")
    private Long id_election_candidat;

    @ManyToOne //Relation de many to one entre l'entité Election
    @JoinColumn(name = "id_election", referencedColumnName = "id_election") //Jointure de clé etrangere
    private Election election;

    @ManyToOne  // Relation de many to one aec la table Candidat
    @JoinColumn(name = "id_candidat", referencedColumnName = "id_candidat") //Jointure de clé etrangere
    private Candidat candidat;

    @Column(name = "date_inscription", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateInscription = LocalDateTime.now();

    // Constructeur personnalisé pour créer une instance sans l'ID
    public ElectionCandidat(Election idelection, Candidat idcandidat) {
        this.election = idelection;
        this.candidat = idcandidat;
    }


}