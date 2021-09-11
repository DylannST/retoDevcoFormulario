package com.example.prueba.controller;


import com.example.prueba.entity.Question;
import com.example.prueba.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("api/question")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PutMapping("api/question")
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @GetMapping("api/questionWithAnswer/{idForm}")
    public List<Object> getForIdForm(@PathVariable Long idForm) {
        return questionService.getForIdForm(idForm);
    }

}
