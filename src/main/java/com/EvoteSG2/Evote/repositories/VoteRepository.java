package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Vote;
import com.EvoteSG2.Evote.entities.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, VoteId> {
    List<Vote> findById_IdElection(Integer idElection);
    List<Vote> findById_IdElecteur(Integer idElecteur);
    List<Vote> findByidCandidat(Integer idCandidat);
    List<Vote> findByEstValide(Boolean estValide);
    List<Vote> findByEstAnonyme(Boolean estAnonyme);
}