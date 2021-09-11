package com.example.prueba.interfaces;

import com.example.prueba.entity.Candidate;

public interface CandidateServiceInterface {

    Candidate get(Long id);

    Candidate saveCandidate(Candidate candidate);

}
