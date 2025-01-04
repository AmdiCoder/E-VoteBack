package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Candidat;
import com.EvoteSG2.Evote.entities.Election;
import com.EvoteSG2.Evote.entities.ElectionCandidat;
import com.EvoteSG2.Evote.repositories.CandidatRepository;
import com.EvoteSG2.Evote.repositories.ElectionCandidatRepository;
import com.EvoteSG2.Evote.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionCandidatService {

    @Autowired
    private ElectionCandidatRepository electionCandidatRepository;
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private CandidatRepository candidatRepository;

    public List<ElectionCandidat> getAllElectionCandidat() {return electionCandidatRepository.findAll();}

    public ElectionCandidat createElectionCandidat(Long idElection, Long idUtilisateur) {
        // Récupérer les entités Election et Candidat depuis la base
        Election election = electionRepository.findById(idElection).orElse(null);
        Candidat candidat = candidatRepository.findById(Math.toIntExact(idUtilisateur)).orElse(null);

        // Créer l'entité ElectionCandidat
        ElectionCandidat electionCandidat = new ElectionCandidat();
        electionCandidat.setElection(election);
        electionCandidat.setCandidat(candidat);

        // Sauvegarder ElectionCandidat
        return electionCandidatRepository.save(electionCandidat);
    }
    public ElectionCandidat updateElectionCandidat(ElectionCandidat electionCandidat) {
        return electionCandidatRepository.save(electionCandidat);
    }
    public void deleteElectionCandidat(Long idelection, Long idutilisateur) {

        // Trouver l'entité ElectionCandidat basée sur les identifiants
        ElectionCandidat electionCandidat = electionCandidatRepository.findByElectionAndCandidat(idelection, idutilisateur)
                .orElseThrow(() -> new IllegalArgumentException("Verifier les identifiants saisies"));

        // Supprimer l'entité ElectionCandidat
        electionCandidatRepository.deleteById(electionCandidat.getId_election_candidat());

        }
    }




