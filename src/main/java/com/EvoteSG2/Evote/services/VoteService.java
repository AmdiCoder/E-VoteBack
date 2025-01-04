package com.EvoteSG2.Evote.services;

import com.EvoteSG2.Evote.entities.Vote;
import com.EvoteSG2.Evote.repositories.VoteRepository;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public long countVotesByElectionAndCandidat(long idElection, long idCandidat) {
        return voteRepository.countByElectionAndCandidat(idElection,idCandidat);
    }
    public long countVotesByElection(long idElection) {
        return voteRepository.countByElection(idElection);
    }


}
