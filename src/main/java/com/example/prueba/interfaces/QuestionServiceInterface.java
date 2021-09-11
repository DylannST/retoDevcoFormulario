package com.example.prueba.interfaces;

import com.example.prueba.entity.Question;

import java.util.List;

public interface QuestionServiceInterface {

    Question saveQuestion(Question question);

    void updateQuestion(Question questions);

    List<Object> getForIdForm(Long idForm);
}
