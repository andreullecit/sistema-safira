package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public void saveCandidate(Candidate candidate) {
        candidate.setCreatedAt(LocalDateTime.now());
        this.candidateRepository.save(candidate);
    }

    public List<Candidate> findByStatus(char status){

        return candidateRepository.findByStatus(status);
    }

}
