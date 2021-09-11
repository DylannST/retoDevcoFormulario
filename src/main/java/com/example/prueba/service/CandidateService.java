package com.example.prueba.service;

import com.example.prueba.entity.Candidate;
import com.example.prueba.interfaces.CandidateServiceInterface;
import com.example.prueba.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    CandidateRepository candidateRepository;


    public Candidate get(Long id) {
        return candidateRepository.findById(id).get();
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
