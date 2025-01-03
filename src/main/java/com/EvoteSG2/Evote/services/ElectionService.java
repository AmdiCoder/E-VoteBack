package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Election;
import com.EvoteSG2.Evote.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    public Election getElectionById(Integer id) {
        return electionRepository.findById(id).orElse(null);
    }

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    public void deleteElection(Integer id) {
        electionRepository.deleteById(id);
    }
}