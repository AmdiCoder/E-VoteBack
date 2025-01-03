package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.ElectionCandidat;
import com.EvoteSG2.Evote.entities.ElectionCandidatId;
import com.EvoteSG2.Evote.services.ElectionCandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/election-candidats")
public class ElectionCandidatController {

    private final ElectionCandidatService electionCandidatService;

    @Autowired
    public ElectionCandidatController(ElectionCandidatService electionCandidatService) {
        this.electionCandidatService = electionCandidatService;
    }

    @GetMapping
    public ResponseEntity<List<ElectionCandidat>> getAllElectionCandidats() {
        List<ElectionCandidat> electionCandidats = electionCandidatService.getAllElectionCandidats();
        return ResponseEntity.ok(electionCandidats);
    }

    @GetMapping("/{idElection}/{idCandidat}")
    public ResponseEntity<ElectionCandidat> getElectionCandidatById(@PathVariable Integer idElection, @PathVariable Integer idCandidat) {
        ElectionCandidatId id = new ElectionCandidatId(idElection, idCandidat);
        ElectionCandidat electionCandidat = electionCandidatService.getElectionCandidatById(id);
        return ResponseEntity.ok(electionCandidat);
    }

    @PostMapping
    public ResponseEntity<ElectionCandidat> createElectionCandidat(@RequestBody ElectionCandidat electionCandidat) {
        ElectionCandidat newElectionCandidat = electionCandidatService.createElectionCandidat(electionCandidat);
        return ResponseEntity.ok(newElectionCandidat);
    }

    @PutMapping("/{idElection}/{idCandidat}")
    public ResponseEntity<ElectionCandidat> updateElectionCandidat(@PathVariable Integer idElection, @PathVariable Integer idCandidat, @RequestBody ElectionCandidat electionCandidat) {
        ElectionCandidat updatedElectionCandidat = electionCandidatService.updateElectionCandidat(electionCandidat);
        return ResponseEntity.ok(updatedElectionCandidat);
    }

    @DeleteMapping("/{idElection}/{idCandidat}")
    public ResponseEntity<Void> deleteElectionCandidat(@PathVariable Integer idElection, @PathVariable Integer idCandidat) {
        ElectionCandidatId id = new ElectionCandidatId(idElection, idCandidat);
        electionCandidatService.deleteElectionCandidat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/election/{idElection}")
    public ResponseEntity<List<ElectionCandidat>> findByElectionId(@PathVariable Integer idElection) {
        List<ElectionCandidat> electionCandidats = electionCandidatService.findByElectionId(idElection);
        return ResponseEntity.ok(electionCandidats);
    }

    @GetMapping("/candidat/{idCandidat}")
    public ResponseEntity<List<ElectionCandidat>> findByCandidatId(@PathVariable Integer idCandidat) {
        List<ElectionCandidat> electionCandidats = electionCandidatService.findByCandidatId(idCandidat);
        return ResponseEntity.ok(electionCandidats);
    }
}