package com.example.prueba.repository;

import com.example.prueba.entity.CandidateForm;
import com.example.prueba.util.CandidateFormCompound;
import org.springframework.data.repository.CrudRepository;

public interface CandidateFormRepository extends CrudRepository<CandidateForm, CandidateFormCompound> {

}
