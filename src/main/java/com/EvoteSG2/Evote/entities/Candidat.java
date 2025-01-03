package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidat", schema = "evote_db", indexes = {
        @Index(name = "idx_candidat_parti", columnList = "parti")
})
public class Candidat {
    @Id
    @Column(name = "id_candidat", nullable = false)
    private Integer id;

    @Column(name = "parti", nullable = false, length = 100)
    private String parti;

    @Lob
    @Column(name = "programme")
    private String programme;

    @Lob
    @Column(name = "biographie")
    private String biographie;

}