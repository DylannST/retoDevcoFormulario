package com.example.prueba.service;

import com.example.prueba.entity.Form;
import com.example.prueba.entity.Question;
import com.example.prueba.repository.QuestionRepository;
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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionService questionService;

    Question question = new Question(1L, "capital de España", new Form(1L, ""));

    @Test
    void saveQuestion() {
        when(questionRepository.save(question)).thenReturn(question);
        assertEquals("capital de España", questionService.saveQuestion(question).getDescription());
    }

    @Test
    void updateQuestion() {
        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(String.class);
        doNothing()
                .when(questionRepository)
                .updateQuestion((String) valueCapture.capture(), isA(Long.class), isA(Long.class));

        questionService.updateQuestion(question);
        assertEquals("capital de España", valueCapture.getValue());
    }

    @Test
    void getForIdForm() {
        Long id = 1L;
        List<Object> questionForForm = new ArrayList<>();
        questionForForm.add("capital de Argentina");
        questionForForm.add("que es Reactividad");
        when(questionRepository.getForIdForm(id)).thenReturn(questionForForm);

        List<Object> results = questionService.getForIdForm(id);
        assertEquals("que es Reactividad", results.get(1));

    }
}