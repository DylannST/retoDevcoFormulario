package com.example.prueba.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "opciones")
public class Opcion {

    @Id
    @Column(name = "idOpcion", length = 8)
    String idOpcion;

    @JoinColumn(name = "descripcion")
    String descripcion;

    @JoinColumn(name = "acertado")
    boolean acertado;

    @JoinColumn(name = "idPregunta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pregunta pregunta;

    public Opcion() {
    }

    public String getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAcertado() {
        return acertado;
    }

    public void setAcertado(boolean acertado) {
        this.acertado = acertado;
    }
}
