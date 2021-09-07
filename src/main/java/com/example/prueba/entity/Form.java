package com.example.prueba.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "form")
@Data
public class Form {

    @Id
    @Column(name = "idForm", length = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String idForm;

    @JoinColumn(name = "description")
    String description;


    @OneToMany(mappedBy = "form", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CandidateForm> candidateForms;


    @OneToMany(mappedBy = "form", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Question> questions;

    public Form() {
    }


}
