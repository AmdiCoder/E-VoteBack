package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Candidat;
import com.EvoteSG2.Evote.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        List<Candidat> candidats = candidatService.getAllCandidats();
        return ResponseEntity.ok(candidats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable Integer id) {
        Candidat candidat = candidatService.getCandidatById(id);
        return ResponseEntity.ok(candidat);
    }

    @PostMapping
    public ResponseEntity<Object> createCandidat(@RequestBody Candidat candidat) {
        try {
            Candidat newCandidat = candidatService.createCandidat(candidat);
            return new ResponseEntity<>(newCandidat, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Erreur de creation du candidat : " +e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable Integer id, @RequestBody Candidat candidat) {
        Candidat updatedCandidat = candidatService.updateCandidat(id, candidat);
        return ResponseEntity.ok(updatedCandidat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable Integer id) {
        candidatService.deleteCandidat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/parti/{parti}")
    public ResponseEntity<List<Candidat>> findByParti(@PathVariable String parti) {
        List<Candidat> candidats = candidatService.findByParti(parti);
        return ResponseEntity.ok(candidats);
    }
}