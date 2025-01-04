package com.EvoteSG2.Evote.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "election")

public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_election", nullable = false)
    private Long idElection;

    @Column(name = "date_debut", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateDebut;

    @Column(name = "date_fin", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dateFin;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @ColumnDefault("1")
    @Column(name = "est_active")
    private Boolean estActive;

    @Column(name = "created_by")
    private Integer createdBy;

}