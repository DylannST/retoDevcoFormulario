package com.example.prueba.interfaces;

import com.example.prueba.entity.CandidateForm;

import java.util.List;

public interface CandidateFormServiceInterface {

    void saveCandidateForm(CandidateForm candidateForm);

    Long getMedia(Long idCandidate, Long idform);

    List<Object> getFormOfACandidate(CandidateForm candidateForm);
}
