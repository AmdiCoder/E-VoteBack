package com.EvoteSG2.Evote.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "electeur")
@DiscriminatorValue("Electeur")
@PrimaryKeyJoinColumn(name = "id_electeur", referencedColumnName = "id_utilisateur")
@Getter
@Setter
public class Electeur extends Utilisateur{

    @Column(name = "region", nullable = false, length = 100)
    private String region;

    @Column(name = "departement", nullable = false, length = 100)
    private String departement;

}