package com.example.prueba.repository;

import com.example.prueba.entity.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String> {
    @Query(value = "UPDATE question\n" +
            "SET description = ?1\n" +
            "WHERE id_form=?2 AND\n" +
            "id_question=?3", nativeQuery = true)
    void updateQuestion(String description, Long idForm, String idQuestion);

}
