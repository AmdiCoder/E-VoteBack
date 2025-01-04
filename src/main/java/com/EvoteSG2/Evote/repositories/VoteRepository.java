package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Rechercher des votes par id_election et id_candidat
    public List<Vote> findByElection_IdElectionAndCandidat_IdUtilisateur(long idElection, long idCandidat);

    // Rechercher tous les votes pour une élection donnée
    List<Vote> findByElection_IdElection(int idElection);

    //Requete pour recuperer l'entité vote à partir de l'idelection et de l'idcandidat
    @Query("SELECT  ec FROM Vote ec " +
            "WHERE ec.election.idElection = :idElection AND ec.candidat.idUtilisateur = :idCandidat")
    Optional<Vote> findByElectionAndCandidat(@Param("idElection") long idElection, @Param("idCandidat") long idCandidat);

    //Requete pour compter les votes par election et par candidat
    @Query("SELECT COUNT(ec)FROM Vote ec " +
              "WHERE ec.election.idElection = :idElection AND ec.candidat.idUtilisateur = :idCandidat")
    long countByElectionAndCandidat(@Param("idElection") long idElection, @Param("idCandidat") long idCandidat);;

    //Requete pour compter l'ensemble des votes par election
    @Query("SELECT COUNT(ec)FROM Vote ec " +
            "WHERE ec.election.idElection = :idElection")
    long countByElection(@Param("idElection") long idElection);;

}
