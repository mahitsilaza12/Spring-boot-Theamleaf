package com.company.lieu;

import com.company.affectation.Affectation;
import com.company.employe.Employe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lieu")
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code_lieu;
    @Column(nullable = false)
    private String designation;
    @Column(nullable = false)
    private String province;

    @OneToMany(mappedBy = "lieu")
    private List<Affectation> affectations = new ArrayList<Affectation>();

    public Integer getCode_lieu() {
        return code_lieu;
    }

    public void setCode_lieu(Integer code_lieu) {
        this.code_lieu = code_lieu;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "code_lieu=" + code_lieu +
                ", designation='" + designation + '\'' +
                ", province='" + province +
                '}';
    }
}
