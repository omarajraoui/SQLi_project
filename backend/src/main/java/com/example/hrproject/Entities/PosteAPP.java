package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table()
@Getter
@Setter
public class PosteAPP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String datePostAPP;
    @Column
    private String postAppName;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "matricule", nullable = false)
    private Collaborateur collaborateur;


}