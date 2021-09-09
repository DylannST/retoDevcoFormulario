package com.example.prueba.repository;

import com.example.prueba.entity.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE question\n" +
            "SET description = ?1\n" +
            "WHERE id_form=?2 AND\n" +
            "id_question=?3", nativeQuery = true)
    Integer updateQuestion(String description, Long idForm, Long idQuestion);

    @Query(value = "SELECT description FROM question WHERE id_form=?1", nativeQuery = true)
    List<Object> getForIdForm(Long idForm);


}
