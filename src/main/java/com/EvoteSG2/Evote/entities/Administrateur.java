package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administrateur", schema = "evote_db", indexes = {
        @Index(name = "idx_admin_matricule", columnList = "matricule")
}, uniqueConstraints = {
        @UniqueConstraint(name = "matricule", columnNames = {"matricule"})
})
public class Administrateur {
    @Id
    @Column(name = "id_admin", nullable = false)
    private Integer id;

    @Column(name = "matricule", nullable = false, length = 50)
    private String matricule;

}