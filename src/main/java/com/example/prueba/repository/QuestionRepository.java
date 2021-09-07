package com.example.prueba.repository;

import com.example.prueba.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String> {
}
