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

    // Méthode pour mettre à jour un candidat
    public Candidat updateCandidat(Integer id, Candidat candidat) {
        // Vérifie si le candidat existe dans la base de données
        Candidat existingCandidat = candidatRepository.findById(id).orElse(null);

        if (existingCandidat != null) {
            // Met à jour les propriétés du candidat existant
            existingCandidat.setPrenom(candidat.getPrenom());
            existingCandidat.setNom(candidat.getNom());
            existingCandidat.setParti(candidat.getParti());
            existingCandidat.setProgramme(candidat.getProgramme());
            existingCandidat.setBiographie(candidat.getBiographie());

            // Sauvegarde le candidat mis à jour
            return candidatRepository.save(existingCandidat);
        }

        // Si le candidat n'existe pas, retourne null
        return null;
    }

    public void deleteCandidat(Integer id) {
        candidatRepository.deleteById(id);
    }

    public List<Candidat> findByParti(String parti) {
        return candidatRepository.findByParti(parti);
    }
}