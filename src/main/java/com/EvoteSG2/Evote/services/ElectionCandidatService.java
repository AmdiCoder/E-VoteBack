package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.ElectionCandidat;
import com.EvoteSG2.Evote.entities.ElectionCandidatId;
import com.EvoteSG2.Evote.repositories.ElectionCandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionCandidatService {

    private final ElectionCandidatRepository electionCandidatRepository;

    @Autowired
    public ElectionCandidatService(ElectionCandidatRepository electionCandidatRepository) {
        this.electionCandidatRepository = electionCandidatRepository;
    }

    public List<ElectionCandidat> getAllElectionCandidats() {
        return electionCandidatRepository.findAll();
    }

    public ElectionCandidat getElectionCandidatById(ElectionCandidatId id) {
        return electionCandidatRepository.findById(id).orElse(null);
    }

    public ElectionCandidat createElectionCandidat(ElectionCandidat electionCandidat) {
        return electionCandidatRepository.save(electionCandidat);
    }

    public ElectionCandidat updateElectionCandidat(ElectionCandidat electionCandidat) {
        return electionCandidatRepository.save(electionCandidat);
    }

    public void deleteElectionCandidat(ElectionCandidatId id) {
        electionCandidatRepository.deleteById(id);
    }

    public List<ElectionCandidat> findByElectionId(Integer idElection) {
        return electionCandidatRepository.findById_IdElection(idElection);
    }

    public List<ElectionCandidat> findByCandidatId(Integer idCandidat) {
        return electionCandidatRepository.findById_IdCandidat(idCandidat);
    }
}