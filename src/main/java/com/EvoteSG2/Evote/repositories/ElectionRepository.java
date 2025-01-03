package com.EvoteSG2.Evote.repositories;

import com.EvoteSG2.Evote.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
    }