package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.ElectionCandidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectionCandidatRepository extends JpaRepository<ElectionCandidat, Long> {

    @Query("SELECT ec FROM ElectionCandidat ec " +
            "WHERE ec.election.idElection = :idElection AND ec.candidat.idUtilisateur = :idCandidat")
    Optional<ElectionCandidat> findByElectionAndCandidat(@Param("idElection") Long idElection, @Param("idCandidat") Long idCandidat);
}
