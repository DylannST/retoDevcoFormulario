package com.example.prueba.entity;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "idQuestion", length = 8)
    String idQuestion;

    @JoinColumn(name = "description")
    String description;

    @JoinColumn(name = "idForm")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Form form;

    public Question() {
    }

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Option> options;


}
