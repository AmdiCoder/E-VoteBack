package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.*;
import com.EvoteSG2.Evote.repositories.CandidatRepository;
import com.EvoteSG2.Evote.repositories.ElectionCandidatRepository;
import com.EvoteSG2.Evote.repositories.ElectionRepository;
import com.EvoteSG2.Evote.services.ElectionCandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ec")
public class ElectionCandidatController {

    @Autowired
    private ElectionCandidatService electionCandidatService;


    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @GetMapping
    public ResponseEntity<List<ElectionCandidat>> getAllElectionCandidat() {
        List<ElectionCandidat> electionCandidats = electionCandidatService.getAllElectionCandidat();
        return ResponseEntity.ok(electionCandidats);
    }

    @PostMapping
    public ResponseEntity<ElectionCandidat> createElectionCandidat(
            @RequestParam Long idElection,
            @RequestParam Long idUtilisateur) {

        // Récupération des entités Election et Candidat depuis la base de données
        Election election = electionRepository.findById(idElection)
                .orElseThrow(() -> new IllegalArgumentException("Election not found with id: " + idElection));

        Candidat candidat = candidatRepository.findById(Math.toIntExact(idUtilisateur))
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found with id: " + idUtilisateur));

        // Appel de la méthode du service pour créer l'ElectionCandidat
        ElectionCandidat electionCandidat = electionCandidatService.createElectionCandidat(election.getIdElection(), candidat.getIdUtilisateur());

        return ResponseEntity.ok(electionCandidat);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteElectionCandidat(
            @RequestParam Long idElection,
            @RequestParam Long idUtilisateur) {

        try {
            // Appel du service pour supprimer l'enregistrement
            electionCandidatService.deleteElectionCandidat(idElection, idUtilisateur);
            return ResponseEntity.ok("Supprimé");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
