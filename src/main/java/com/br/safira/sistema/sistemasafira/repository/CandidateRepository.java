package com.br.safira.sistema.sistemasafira.repository;

import com.br.safira.sistema.sistemasafira.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
    public List<Candidate> findByStatus(char status);
}
