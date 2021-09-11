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


    public Form(Long idForm, String description) {
        this.idForm = idForm;
        this.description = description;
    }

    public Form() {
    }


    public Form(Long idForm) {
        this.idForm = idForm;
    }
}