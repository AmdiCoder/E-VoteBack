package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Candidat;
import com.EvoteSG2.Evote.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    public Candidat getCandidatById(Integer id) {
        return candidatRepository.findById(id).orElse(null);
    }

    public Candidat createCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public void deleteCandidat(Integer id) {
        candidatRepository.deleteById(id);
    }

    public List<Candidat> findByParti(String parti) {
        return candidatRepository.findByParti(parti);
    }
}