package com.example.prueba.service;

import com.example.prueba.entity.Candidate;
import com.example.prueba.entity.CandidateForm;
import com.example.prueba.entity.Form;
import com.example.prueba.repository.CandidateFormRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CandidateFormServiceTest {

    @Mock
    CandidateFormRepository candidateFormRepository;

    @InjectMocks
    CandidateFormService candidateFormService;

    CandidateForm candidateForm = new CandidateForm();

    @Test
    void saveCandidateForm() {
        candidateForm.setMedia(4L);
        candidateForm.setForm(new Form(1L));
        candidateForm.setCandidate(new Candidate(225L, ""));

        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(Long.class);
        doNothing().when(candidateFormRepository)
                .insert((Long) valueCapture.capture(), (Long) valueCapture.capture(), (Long) valueCapture.capture());
        candidateFormService.saveCandidateForm(candidateForm);
        assertEquals(4L, valueCapture.getAllValues().get(0));
        assertEquals(1L, valueCapture.getAllValues().get(1));
        assertEquals(225L, valueCapture.getAllValues().get(2));


    }

    @Test
    void getFormOfACandidate() {

        List<Object> objetos = new ArrayList<>();
        candidateForm.setForm(new Form(1L));
        candidateForm.setCandidate(new Candidate(225L, ""));
        objetos.add(new String[]{"cuanto es 2*9", "es 18"});
        objetos.add(new String[]{"raiz de 2025", "es 45"});

        when(candidateFormRepository.getFormOfACandidate(
                candidateForm.getCandidate().getId(),
                candidateForm.getForm().getIdForm())
        ).thenReturn(objetos);
        String resultado[] = (String[]) candidateFormService.getFormOfACandidate(candidateForm).get(0);

        assertEquals("es 18", resultado[1]);

    }
}