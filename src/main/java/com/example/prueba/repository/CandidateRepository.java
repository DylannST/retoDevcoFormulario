package com.example.prueba.repository;

import com.example.prueba.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {



}
