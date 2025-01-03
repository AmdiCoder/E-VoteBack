package com.EvoteSG2.Evote.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class VoteId implements java.io.Serializable {
    private static final long serialVersionUID = 8825755168025531606L;
    @Column(name = "id_election", nullable = false)
    private Integer idElection;

    @Column(name = "id_electeur", nullable = false)
    private Integer idElecteur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VoteId entity = (VoteId) o;
        return Objects.equals(this.idElecteur, entity.idElecteur) &&
                Objects.equals(this.idElection, entity.idElection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElecteur, idElection);
    }

}