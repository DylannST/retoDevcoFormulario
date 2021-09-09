package com.example.prueba.controller;


import com.example.prueba.entity.Candidate;
import com.example.prueba.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("api/candidate/{id}")
    public Candidate getCandidateById(@PathVariable("id") String id) {
        return candidateService.get(id);
    }


    @PostMapping("api/candidate")
    public Candidate saveCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }


}
