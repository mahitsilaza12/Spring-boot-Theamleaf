package com.company.affectation;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface AffectationRepository extends JpaRepository<Affectation, Integer> {

    @Query(value = "SELECT id,lieu_id,date, province,employe_id, nom FROM Affectation,Lieu,Employes where Affectation.lieu_id=Lieu.code_lieu AND Affectation.employe_id = Employes.code_emp  ", nativeQuery = true)
    List<Affectation> trouve();
}
