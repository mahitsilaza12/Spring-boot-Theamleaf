package com.company.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired private EmployeRepository repo;

    public List<Employe> listAll(){
        return (List<Employe>) repo.findAll();
    }
    public void save(Employe employe){
        repo.save(employe);
    }
    public Employe get(Integer code_emp) throws EmployeNotFoundException{
        Optional<Employe> result =repo.findById(code_emp);
        if(result.isPresent()){
            return result.get();
        }
        throw  new EmployeNotFoundException("emplyee not found"+ code_emp);
    }
    public void delete(Integer code_emp) {
        repo.deleteById(code_emp);
    }


}
