package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.json.JSONParser;

import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vote")
    private long idVote;

    @ManyToOne
    @JoinColumn(name = "id_election", referencedColumnName = "id_election")
    private Election election;

    @ManyToOne
    @JoinColumn(name = "id_electeur", referencedColumnName = "id_electeur")
    private Electeur electeur;

    @ManyToOne
    @JoinColumn(name = "id_candidat", referencedColumnName = "id_candidat")
    private Candidat candidat;

    @Column(name = "heure_vote", nullable = false)
    private LocalDateTime heureVote = LocalDateTime.now();

    @Column(name = "est_valide", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean estValide = true;

    @Column(name = "est_anonyme", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean estAnonyme = true;

}
