package com.company.employe;

import com.company.affectation.Affectation;
import com.company.lieu.Lieu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employes")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code_emp;
    @Column(nullable = false, length = 40, name = "nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(nullable = false,name = "poste")
    private String poste;

    @OneToMany(mappedBy = "employe")
    private List<Affectation> affectations = new ArrayList<Affectation>();

    public Integer getCode_emp() {
        return code_emp;
    }

    public void setCode_emp(Integer code_emp) {
        this.code_emp = code_emp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "code_emp=" + code_emp +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}
