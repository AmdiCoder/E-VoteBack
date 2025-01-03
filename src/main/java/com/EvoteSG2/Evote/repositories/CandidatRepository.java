package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    List<Candidat> findByParti(String parti);
}