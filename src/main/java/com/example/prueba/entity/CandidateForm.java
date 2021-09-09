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

//    @JoinColumn(name = "state")
//    boolean stateR;

    @Id
    @JoinColumn(name = "idForm", unique = true, nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Form form;

    @Id
    @JoinColumn(name = "idCandidate", unique = true, nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Candidate candidate;

    public CandidateForm() {
    }


}