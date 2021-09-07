package com.example.prueba.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "formulario")
public class Formulario {

    @Id
    @Column(name = "idFormulario",length = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    String idFormulario;

    @JoinColumn(name = "descripcion")
    String descripcion;


    @OneToMany(mappedBy = "formulario", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CandidatoFormulario> candidatoFormularios;


    @OneToMany(mappedBy = "formulario", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Pregunta> preguntas;

    public Formulario() {
    }

    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<CandidatoFormulario> getCandidatoFormularios() {
        return candidatoFormularios;
    }

    public void setCandidatoFormularios(Set<CandidatoFormulario> candidatoFormularios) {
        this.candidatoFormularios = candidatoFormularios;
    }

    public Set<Pregunta> getPregunta() {
        return preguntas;
    }

    public void setPregunta(Set<Pregunta> pregunta) {
        this.preguntas = pregunta;
    }
}
