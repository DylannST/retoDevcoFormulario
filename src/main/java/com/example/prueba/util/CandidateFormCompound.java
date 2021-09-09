package com.example.prueba.util;

import com.example.prueba.entity.Candidate;
import com.example.prueba.entity.Form;
import lombok.Data;

import java.io.Serializable;

@Data
public class CandidateFormCompound implements Serializable {
    private Candidate candidate;
    private Form form;

    public CandidateFormCompound() {
    }


}
