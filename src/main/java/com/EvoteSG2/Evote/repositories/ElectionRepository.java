package com.EvoteSG2.Evote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EvoteSG2.Evote.entities.Election;



@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
}