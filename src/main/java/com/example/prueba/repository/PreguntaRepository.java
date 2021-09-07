package com.example.prueba.repository;

import com.example.prueba.entity.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface PreguntaRepository extends CrudRepository<Pregunta, String> {
}
