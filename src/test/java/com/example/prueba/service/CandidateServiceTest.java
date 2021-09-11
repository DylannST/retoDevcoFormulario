package com.example.prueba.service;

import com.example.prueba.entity.Candidate;
import com.example.prueba.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    CandidateService candidateService;
    Candidate candidate = new Candidate(4444L, "Dylann");


    @Test
    public void saveCandidate() {


        when(candidateRepository.save(candidate)).thenReturn(candidate);

        Candidate result = candidateService.saveCandidate(candidate);

        assertEquals("Dylann", result.getName());
    }

    @Test
    public void get() {
        Long id = 4444L;

        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        assertNotNull(candidateService.get(id));

    }
}