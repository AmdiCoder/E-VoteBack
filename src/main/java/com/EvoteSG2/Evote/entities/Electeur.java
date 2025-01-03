package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "electeur", schema = "evote_db", indexes = {
        @Index(name = "idx_electeur_region", columnList = "region")
})
public class Electeur {
    @Id
    @Column(name = "id_electeur", nullable = false)
    private Integer id;

    @Column(name = "region", nullable = false, length = 100)
    private String region;

    @Column(name = "departement", nullable = false, length = 100)
    private String departement;

    @ColumnDefault("0")
    @Column(name = "a_vote")
    private Boolean aVote;

}