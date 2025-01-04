package com.EvoteSG2.Evote.controlleurs;

import com.EvoteSG2.Evote.entities.Vote;
import com.EvoteSG2.Evote.services.VoteService;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote saved = voteService.saveVote(vote);
        return ResponseEntity.ok(saved);
    }

    // Méthode pour compter les votes par élection et candidat
    @GetMapping("/count/election/{idElection}/candidat/{idCandidat}")
    public ResponseEntity<Long> countVotesByElectionAndCandidat(
            @PathVariable long idElection,
            @PathVariable long idCandidat) {

        long count = voteService.countVotesByElectionAndCandidat(idElection, idCandidat);
        return ResponseEntity.ok(count); // Retourner le nombre de votes avec un statut 200 OK
    }
    // Méthode pour compter les votes par élection
    @GetMapping("/count/election/{idElection}")
    public ResponseEntity<Long> countVotesByElection(@PathVariable long idElection) {
        long count = voteService.countVotesByElection(idElection);
        return ResponseEntity.ok(count); // Retourner le nombre de votes avec un statut 200 OK
    }

}
