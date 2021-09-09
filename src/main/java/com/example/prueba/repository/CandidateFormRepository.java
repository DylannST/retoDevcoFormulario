package com.example.prueba.repository;

import com.example.prueba.entity.CandidateForm;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CandidateFormRepository extends CrudRepository<CandidateForm, Long> {

    @Query(value = "select media from candidate_form WHERE id_candidate=?1 and id_form=?2", nativeQuery = true)
    Long getMedia(Long idCandidate, Long idForm);

    @Query(value = "SELECT q.description as Question,op.description as optionTrue from candidate as ca\n" +
            "INNER JOIN candidate_form as cf on cf.id_candidate=ca.id\n" +
            "INNER JOIN form as f on cf.id_form=f.id_form\n" +
            "INNER JOIN question as q on q.id_form=f.id_form\n" +
            "INNER JOIN options as op on op.\tid_question=q.id_question\n" +
            "WHERE ca.id =?1 AND f.id_form=?2", nativeQuery = true)
    List<Object> getFormOfACandidate(Long idCandidate, Long idForm);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO candidate_form (media,id_form, id_candidate)\n" +
            "VALUES (?1, ?2, ?3)",
            nativeQuery = true)
    void insert(Long media, /*boolean state,*/ Long idForm, Long idCandidate);


}
