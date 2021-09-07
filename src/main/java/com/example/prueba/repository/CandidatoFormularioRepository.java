package com.example.prueba.repository;

import com.example.prueba.entity.CandidatoFormulario;
import com.example.prueba.util.CandidatoFormularioCompuesto;
import org.springframework.data.repository.CrudRepository;

public interface CandidatoFormularioRepository extends CrudRepository<CandidatoFormulario, CandidatoFormularioCompuesto> {

}
