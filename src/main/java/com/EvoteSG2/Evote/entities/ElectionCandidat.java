package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "election_candidat", schema = "evote_db", indexes = {
        @Index(name = "id_candidat", columnList = "id_candidat")
})
public class ElectionCandidat {
    @EmbeddedId
    private ElectionCandidatId id;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "date_inscription")
    private Instant dateInscription;

}