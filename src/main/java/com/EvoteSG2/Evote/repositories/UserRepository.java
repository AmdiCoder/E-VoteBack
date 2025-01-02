package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
}