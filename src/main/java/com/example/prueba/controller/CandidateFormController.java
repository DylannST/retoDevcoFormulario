package com.example.prueba.controller;


import com.example.prueba.entity.CandidateForm;
import com.example.prueba.service.CandidateFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class CandidateFormController {

    @Autowired
    CandidateFormService candidateFormService;

    @PostMapping("api/candidateForm")
    public void saveCandidateFormService(@RequestBody CandidateForm candidateForm) {
        candidateFormService.saveCandidateForm(candidateForm);
    }




    @GetMapping("api/candidateForm")
    public List<Object> getFormOfACandidate(@RequestBody CandidateForm candidateForm) {
        return candidateFormService.getFormOfACandidate(candidateForm);
    }

}
