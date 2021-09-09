package com.example.prueba.service;


import com.example.prueba.entity.CandidateForm;
import com.example.prueba.interfaces.CandidateFormServiceInterface;
import com.example.prueba.repository.CandidateFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateFormService implements CandidateFormServiceInterface {


    @Autowired
    CandidateFormRepository candidateFormRepository;

    public void saveCandidateForm(CandidateForm candidateForm) {

         candidateFormRepository.insert(
                candidateForm.getMedia(),
                candidateForm.getForm().getIdForm(),
                candidateForm.getCandidate().getId()
        );

    }

    public Long getMedia(Long idCandidate, Long idform) {
        return candidateFormRepository.getMedia(idCandidate, idform);
    }

    public List<Object> getFormOfACandidate(CandidateForm candidateForm) {
        return candidateFormRepository.getFormOfACandidate(
                candidateForm.getCandidate().getId(),
                candidateForm.getForm().getIdForm()
        );
    }
}
