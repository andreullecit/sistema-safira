package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public void saveCandidate(Candidate candidate) {
        candidate.setCreatedAt(LocalDateTime.now());
        candidate.setStatus('A');
        this.candidateRepository.save(candidate);
    }

    public List<Candidate> findByStatus(char status){
        return candidateRepository.findByStatus(status);
    }

    public boolean deleteCandidate(String id) {
        Optional<Candidate> optional = candidateRepository.findById(id);
        if(optional.isPresent()) {
            candidateRepository.deleteById(id);
            return true;
        }

        return false;
    }

}
