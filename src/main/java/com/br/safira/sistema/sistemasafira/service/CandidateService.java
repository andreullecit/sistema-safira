package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public void saveCandidate(Candidate candidate) {
        this.candidateRepository.save(candidate);
    }

}
