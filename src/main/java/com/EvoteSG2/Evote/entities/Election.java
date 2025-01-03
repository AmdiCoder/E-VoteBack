package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "election", schema = "evote_db", indexes = {
        @Index(name = "created_by", columnList = "created_by")
})
public class Election {
    @Id
    @Column(name = "id_election", nullable = false)
    private Integer id;

    @Column(name = "date_debut", nullable = false)
    private Instant dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Instant dateFin;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @ColumnDefault("1")
    @Column(name = "est_active")
    private Boolean estActive;

    @Column(name = "created_by")
    private Integer createdBy;

}