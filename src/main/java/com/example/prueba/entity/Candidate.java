package com.example.prueba.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "candidate")
public class Candidate {

    @Id
    @Column(name = "cedula", length = 10)
    String id;
    @JoinColumn(name = "nombre")
    String name;


    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CandidateForm> candidateForm;

    public Candidate() {
    }


}
