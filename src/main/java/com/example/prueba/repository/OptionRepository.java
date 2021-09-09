package com.example.prueba.repository;

import com.example.prueba.entity.Options;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface OptionRepository extends CrudRepository<Options, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE options\n" +
            "SET description = ?1, success=?2\n" +
            " WHERE idoption=?3 AND\n" +
            "id_question=?4", nativeQuery = true)
    void updateOptions(String description, boolean success, Long idOption, Long idQuestion);

}
