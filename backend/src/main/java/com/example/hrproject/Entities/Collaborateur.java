package com.example.hrproject.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Collaborateur")
@Getter
@Setter
public class Collaborateur {
    @Id
    private Long matricule;
    private Long matriculeRH;
    private String nom;
    private String prenom;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    private String abrev;
    private String ancienRH;
    private String nouveauRH;
    private String site;
    private char sexe;
    private String bu;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate embauche;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    private int bap;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate depart;
    private boolean ancienCollab;
    private boolean seminaire;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateSeminaire;
    private String poste;
    private String  posteAPP;
    private Double salaire;
    private boolean compteActif;
    private boolean statusActif;
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference
    @Setter(value = AccessLevel.NONE)
    private List<Competence> competences = new ArrayList<>();
    @OneToMany(mappedBy = "collaborateur",cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference
    @Setter(value = AccessLevel.NONE)
    private List<Diplome> diplomes = new ArrayList<>();
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Transient
    SecureRandom sr = new SecureRandom();

    public Collaborateur() throws NoSuchAlgorithmException {
        this.matricule = sr.nextLong(100000);
        this.compteActif = true;
        this.statusActif = true;
    }

    public int getBap() {
        return embauche.getDayOfMonth()>= 15 ? embauche.getMonthValue()+1 :embauche.getMonthValue() ;
    }

    public void setBap(int bap) {
        this.bap = bap;
    }

    public void addCompetences(List<Competence> competences1){
        for(Competence com : competences1) {
            com.setCollaborateur(this);
            competences.add(com);
        }
    }
    public void addDiplomes(List<Diplome> diplomes1){
        System.out.println(diplomes1.size());
        for(Diplome dip : diplomes1){
            dip.setCollaborateur(this);
            diplomes.add(dip);
        }
    }

    public void removeCompetences() {
        this.competences.forEach(Competence::removeCollab);
        this.competences.clear();
    }

    public void removeDiplomes() {
        this.diplomes.forEach(Diplome::removeCollab);
        this.diplomes.clear();
    }

    public String getAbrev() {
        return prenom.charAt(0)+nom.substring(0,2);
    }
    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

}
