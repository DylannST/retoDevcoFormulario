package com.example.prueba.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @Column(name = "idPregunta", length = 8)
    String idPregunta;

    @JoinColumn(name = "descripcion")
    String descripcion;

    @JoinColumn(name = "idFormulario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Formulario formulario;

    public Pregunta() {
    }

    @OneToMany(mappedBy = "pregunta", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Opcion> opciones;

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
