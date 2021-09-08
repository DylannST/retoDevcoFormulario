package com.example.prueba.repository;

import com.example.prueba.entity.CandidateForm;
import com.example.prueba.util.CandidateFormCompound;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateFormRepository extends CrudRepository<CandidateForm, CandidateFormCompound> {

    @Query(value = "select media from candidate_form WHERE id_candidate=?1 and id_form=?2", nativeQuery = true)
    Long getMedia(String idCandidate, Long idForm);

    @Query(value = "SELECT q.description,op.description from candidate_form cf \n" +
            "INNER JOIN form f on cf.id_form=f.id_form\n" +
            "INNER JOIN question q on q.id_form=f.id_form\n" +
            "INNER JOIN options op on op.id_question=q.id_question\n" +
            "WHERE cf.id_candidate=?1 AND cf.id_form=?2", nativeQuery = true)
    List<Object> getFormOfACandidate(String idCandidate, Long idForm);

}
