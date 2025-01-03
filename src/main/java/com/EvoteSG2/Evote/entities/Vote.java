package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "vote", schema = "evote_db", indexes = {
        @Index(name = "id_electeur", columnList = "id_electeur"),
        @Index(name = "id_candidat", columnList = "id_candidat")
})
public class Vote {
    @EmbeddedId
    private VoteId id;

    @Column(name = "id_candidat")
    private Integer idCandidat;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "heure_vote")
    private Instant heureVote;

    @ColumnDefault("1")
    @Column(name = "est_valide")
    private Boolean estValide;

    @ColumnDefault("1")
    @Column(name = "est_anonyme")
    private Boolean estAnonyme;

}