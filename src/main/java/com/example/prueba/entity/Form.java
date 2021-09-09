package com.example.prueba.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "form")
public class Form {

    @Id
    @Column(name = "idForm")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long idForm;

    @JoinColumn(name = "description")
    private String description;


//    @OneToMany(mappedBy = "form", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    private Set<CandidateForm> candidateForms;


//    @OneToMany(mappedBy = "form", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    private Set<Question> questions;

    public Form() {
    }


}