package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Vote;
import com.EvoteSG2.Evote.entities.VoteId;
import com.EvoteSG2.Evote.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote getVoteById(VoteId id) {
        return voteRepository.findById(id).orElse(null);
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public void deleteVote(VoteId id) {
        voteRepository.deleteById(id);
    }

    public List<Vote> findByElectionId(Integer idElection) {
        return voteRepository.findById_IdElection(idElection);
    }

    public List<Vote> findByElecteurId(Integer idElecteur) {
        return voteRepository.findById_IdElecteur(idElecteur);
    }

    public List<Vote> findByCandidatId(Integer idCandidat) {
        return voteRepository.findByidCandidat(idCandidat);
    }
   }