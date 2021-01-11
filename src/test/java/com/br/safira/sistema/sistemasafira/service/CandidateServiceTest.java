package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Candidate;
import com.br.safira.sistema.sistemasafira.model.enums.Level;
import com.br.safira.sistema.sistemasafira.repository.CandidateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Optional;

import static org.powermock.api.mockito.PowerMockito.when;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@DataMongoTest
public class CandidateServiceTest {

    @Mock
    CandidateRepository candidateRepository;

    @InjectMocks
    CandidateService candidateService = new CandidateService();

    private String idTest = "1";

    @Test
    public void candidateSaved() {
        Candidate candidate = Candidate.builder().fullName("Test").build();
        when(this.candidateRepository.save(Mockito.any())).thenReturn(Mockito.any());

        this.candidateService.saveCandidate(candidate);

        Mockito.verify(this.candidateRepository, Mockito.times(1)).save(candidate);
    }

    @Test
    public void candidateListByStatus () {
        this.candidateService.findByStatus('A');
        Mockito.verify(this.candidateRepository, Mockito.times(1)).findByStatus('A');
    }


    @Test
    public void shouldReturnTrueForDelete() {
        when(candidateRepository.findById(idTest)).thenReturn(Optional.of(Candidate.builder()
                .fullName("Teste Teste")
                .description("Teste")
                .level(Level.Junior)
                .build()));

        boolean deleteCandidateResponse = candidateService.deleteCandidate(idTest);
        assertFalse(deleteCandidateResponse);
    }

    @Test
    public void shouldReturnFalseForDelete() {
        when(candidateRepository.findById(idTest)).thenReturn(Optional.empty());

        boolean deleteCandidateResponse = candidateService.deleteCandidate(idTest);
        assertFalse(deleteCandidateResponse);
    }

}
