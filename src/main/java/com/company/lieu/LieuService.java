package com.company.lieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LieuService {
    @Autowired private LieuRepository repo;

    public List<Lieu> lista(){
        return (List<Lieu>) repo.findAll();
    }
    public void save(Lieu lieu){
        repo.save(lieu);
    }
    public Lieu get(Integer code_lieu) throws LieuNotFoundException{
        Optional<Lieu> result = repo.findById(code_lieu);
        if(result.isPresent()){
           return result.get();
        }
        throw  new LieuNotFoundException("Lieu not found " + code_lieu);
    }

    public void delete(Integer code_lieu){
        repo.deleteById(code_lieu);

    }

}
