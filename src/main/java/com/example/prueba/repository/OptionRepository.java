package com.example.prueba.repository;

import com.example.prueba.entity.Options;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Options, String> {

    @Query(value = "UPDATE options\n" +
            "SET description = ?1\n" +
            "WHERE idoption=?2 AND\n" +
            "id_question=?3", nativeQuery = true)
     void updateOptions(String description, Long idOption, Long idQuestion);

}
