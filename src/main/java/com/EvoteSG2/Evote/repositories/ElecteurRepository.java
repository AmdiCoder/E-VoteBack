package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Electeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElecteurRepository extends JpaRepository<Electeur, Integer> {
    List<Electeur> findByRegion(String region);
    List<Electeur> findByDepartement(String departement);
    List<Electeur> findByaVote(Boolean aVote);
}