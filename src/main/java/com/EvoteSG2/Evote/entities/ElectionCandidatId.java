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
public class ElectionCandidatId implements java.io.Serializable {
    private static final long serialVersionUID = 8627963526776557171L;
    @Column(name = "id_election", nullable = false)
    private Integer idElection;

    @Column(name = "id_candidat", nullable = false)
    private Integer idCandidat;

    public ElectionCandidatId(Integer idElection, Integer idCandidat) {
    }

    public ElectionCandidatId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ElectionCandidatId entity = (ElectionCandidatId) o;
        return Objects.equals(this.idCandidat, entity.idCandidat) &&
                Objects.equals(this.idElection, entity.idElection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCandidat, idElection);
    }

}