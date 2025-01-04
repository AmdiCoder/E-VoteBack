package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Election;
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
        return electionRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }


    public Election updateElection(Integer id, Election election) {
        // Vérifie si l'election existe dans la base de données
        Election existingElection = electionRepository.findById(Long.valueOf(id)).orElse(null);

        if (existingElection != null) {
            // Met à jour les propriétés du candidat existant
            existingElection.setDateDebut(election.getDateDebut());
            existingElection.setDateFin(election.getDateFin());
            existingElection.setType(election.getType());
            existingElection.setCreatedBy(election.getCreatedBy());
            // Sauvegarde l'election mis à jour
            return electionRepository.save(existingElection);
        }

        // Si l'election n'existe pas, retourne null
        return null;
    }



    public void deleteElection(Integer id) {
        electionRepository.deleteById(Long.valueOf(id));
    }
}