package com.example.prueba.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "options")
public class Options {

    @Id
    @Column(name = "idoption", length = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idOption;

    @JoinColumn(name = "description")
    String description;

    @JoinColumn(name = "success")
    boolean success;

    @JoinColumn(name = "idQuestion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    public Options() {
    }


}
