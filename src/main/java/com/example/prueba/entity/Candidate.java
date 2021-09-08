package com.example.prueba.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "candidate")
public class Candidate {

    @Id
    @Column(name = "id", length = 10)
    String id;
    @JoinColumn(name = "name")
    String name;


    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CandidateForm> candidateForm;

    public Candidate() {
    }


}
