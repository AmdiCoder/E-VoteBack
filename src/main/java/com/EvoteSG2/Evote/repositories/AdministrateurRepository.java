package com.EvoteSG2.Evote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EvoteSG2.Evote.entities.Administrateur;



@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    Administrateur findByMatricule(String matricule);
}