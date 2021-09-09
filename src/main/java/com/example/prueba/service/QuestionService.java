package com.example.prueba.service;


import com.example.prueba.entity.Question;
import com.example.prueba.interfaces.QuestionServiceInterface;
import com.example.prueba.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements QuestionServiceInterface {

    @Autowired
    QuestionRepository questionRepository;

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }


    public void updateQuestion(Question question) {
        questionRepository.updateQuestion(
                question.getDescription(),
                question.getForm().getIdForm(),
                question.getIdQuestion()
        );
    }

    public List<Object> getForIdForm(Long idForm) {
        return questionRepository.getForIdForm(idForm);
    }

}
