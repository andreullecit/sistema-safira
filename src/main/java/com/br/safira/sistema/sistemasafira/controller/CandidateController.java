package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.request.CandidateRequest;
import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    private Candidate convertRequestToModel(CandidateRequest candidateRequest) {
        return Candidate.builder()
                .fullName(candidateRequest.getFullName())
                .description(candidateRequest.getDescription())
                .level(candidateRequest.getLevel())
                .proficiency(candidateRequest.getProficiency())
                .socialLinks(candidateRequest.getSocialLinks())
                .build();
    }


    @GetMapping
    public List<Candidate> findCandidates() {
        return candidateService.findByStatus('A');
    }

    @PostMapping
    public ResponseEntity addCandidate(@RequestBody @Valid CandidateRequest candidateRequest) {
        candidateService.saveCandidate(convertRequestToModel(candidateRequest));
        return ResponseEntity.ok().build();

    }
}