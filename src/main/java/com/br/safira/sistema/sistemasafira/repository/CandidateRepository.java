package com.br.safira.sistema.sistemasafira.repository;

import com.br.safira.sistema.sistemasafira.controller.request.CandidateRequest;
import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.service.CandidateService;
import com.br.safira.sistema.sistemasafira.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
    @Autowired
    CandidateService candidadteService = new CandidateService();

    @PutMapping("/{id}")
    @Transactional
    public static ResponseEntity<Candidate> saveCandidate(@PathVariable String id, @RequestBody @Valid CandidateRequest updatedCandidate) {
        this.customerRepository.save(updatedCandidate);
    }
}
