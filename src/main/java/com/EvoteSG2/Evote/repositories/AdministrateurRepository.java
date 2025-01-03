package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    Administrateur findByMatricule(String matricule);
}