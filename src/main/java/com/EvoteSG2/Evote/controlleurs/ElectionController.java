package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Election;
import com.EvoteSG2.Evote.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    private final ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @GetMapping
    public ResponseEntity<List<Election>> getAllElections() {
        List<Election> elections = electionService.getAllElections();
        return ResponseEntity.ok(elections);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Election> getElectionById(@PathVariable Integer id) {
        Election election = electionService.getElectionById(id);
        return ResponseEntity.ok(election);
    }

    @PostMapping
    public ResponseEntity<Election> createElection(@RequestBody Election election) {
        Election newElection = electionService.createElection(election);
        return ResponseEntity.ok(newElection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Election> updateElection(@PathVariable Integer id, @RequestBody Election election) {
        Election updatedElection = electionService.updateElection(election);
        return ResponseEntity.ok(updatedElection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElection(@PathVariable Integer id) {
        electionService.deleteElection(id);
        return ResponseEntity.noContent().build();
    }

}