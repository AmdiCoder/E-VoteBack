package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.ElectionCandidat;
import com.EvoteSG2.Evote.entities.ElectionCandidatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionCandidatRepository extends JpaRepository<ElectionCandidat, ElectionCandidatId> {
    List<ElectionCandidat> findById_IdElection(Integer idElection);
    List<ElectionCandidat> findById_IdCandidat(Integer idCandidat);
}