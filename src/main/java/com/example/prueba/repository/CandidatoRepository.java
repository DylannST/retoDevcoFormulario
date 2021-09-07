package com.example.prueba.repository;

import com.example.prueba.entity.Candidato;
import org.springframework.data.repository.CrudRepository;

public interface CandidatoRepository extends CrudRepository<Candidato, String> {
}
