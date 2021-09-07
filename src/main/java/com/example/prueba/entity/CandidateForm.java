package com.example.prueba.entity;


import com.example.prueba.util.CandidateFormCompound;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidateForm")
@IdClass(CandidateFormCompound.class)
public class CandidateForm {


    @JoinColumn(name = "promedio")
    Long media;

    @JoinColumn(name = "state")
    boolean state;

    @Id
    @JoinColumn(name = "idForm")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Form form;

    @Id
    @JoinColumn(name = "idCandidate")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Candidate candidate;

    public CandidateForm() {
    }



}
