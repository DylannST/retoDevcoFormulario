package com.example.prueba.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @Column(name = "cedula", length = 10)
    String cedula;
    @JoinColumn(name = "nombre")
    String nombre;


    @OneToMany(mappedBy = "candidato", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CandidatoFormulario> candidatoFormularios;

    public Candidato() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
