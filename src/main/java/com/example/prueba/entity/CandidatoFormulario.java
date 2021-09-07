package com.example.prueba.entity;


import com.example.prueba.entity.Candidato;
import com.example.prueba.entity.Formulario;
import com.example.prueba.util.CandidatoFormularioCompuesto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name = "CandidatoFormulario")
@IdClass(CandidatoFormularioCompuesto.class)
public class CandidatoFormulario {


    @JoinColumn(name = "promedio")
    Long promedio;

    @JoinColumn(name = "estado")
    boolean estado;

    @Id
    @JoinColumn(name = "idFormulario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Formulario formulario;

    @Id
    @JoinColumn(name = "cedulaCandidato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Candidato candidato;

    public CandidatoFormulario() {
    }


    public Long getPromedio() {
        return promedio;
    }

    public void setPromedio(Long promedio) {
        this.promedio = promedio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
