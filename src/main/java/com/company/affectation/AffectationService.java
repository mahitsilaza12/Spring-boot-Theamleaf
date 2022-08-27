package com.company.affectation;

import com.company.employe.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationService {
    @Autowired private AffectationRepository repo;

    public List<Affectation> lista(){
        return (List<Affectation>) repo.findAll();
    }
    public List<Affectation> lk(){
        return (List<Affectation>) repo.trouve();
    }
    public void save(Affectation affectation){
        repo.save(affectation);
    }
    public Affectation get(Integer id) throws AffectationNotFoundException{
        Optional<Affectation> result = repo.findById(id);
        if(result.isPresent()){
           return result.get();
        }
        throw new AffectationNotFoundException("affectation not found" + id);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }

}
