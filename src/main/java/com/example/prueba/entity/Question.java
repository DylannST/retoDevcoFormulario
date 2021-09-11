package com.example.prueba.entity;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "idQuestion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuestion;

    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "idForm")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Form form;

    public Question() {
    }

    public Question(Long idQuestion, String description, Form form) {
        this.idQuestion = idQuestion;
        this.description = description;
        this.form = form;
    }
}
