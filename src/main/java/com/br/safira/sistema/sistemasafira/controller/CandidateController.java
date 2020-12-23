package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.request.CandidateRequest;
import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.model.enums.Level;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private Candidate convertRequestToModel(CandidateRequest candidateRequest) {
        return Candidate.builder()
                .fullName(candidateRequest.getFullName())
                .description(candidateRequest.getDescription())
                .level(candidateRequest.getLevel())
                .proficiency(candidateRequest.getProficiency())
                .socialLinks(candidateRequest.getSocialLinks())
                .build();
    }
}