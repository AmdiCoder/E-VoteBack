package com.EvoteSG2.Evote.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EvoteSG2.Evote.entities.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    //Optional<Utilisateur> findByUsername(String prenom);

}