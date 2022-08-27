package com.company.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeController {
    @Autowired private EmployeService service;

    @GetMapping("/employe")
    public String Lista(Model model){
        List<Employe> listEmploye = service.listAll();
        model.addAttribute("listEmploye",listEmploye);
        return "Employe/list";
    }
    @GetMapping("/employe/new")
    public String newForm(Model model){
        model.addAttribute("employe",new Employe());
        model.addAttribute("titre","ajout employe");
        return "Employe/new";
    }
    @PostMapping("/employe/save")
    public String save(Employe employe, RedirectAttributes ra){
        service.save(employe);
        ra.addFlashAttribute("message","insertion employee a ete succeess");
        return "redirect:/employe";
    }
    @GetMapping("/employe/edit/{code_emp}")
        public String editing(@PathVariable("code_emp") Integer code_emp,Model model, RedirectAttributes ra){
        try{
            Employe employe = service.get(code_emp);
            model.addAttribute("employe", employe);
            model.addAttribute("titre","modifier employe");
            return "Employe/new";
        }catch (EmployeNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/employe";
        }
    }
    @GetMapping("/employe/delete/{code_emp}")
    public String delete(@PathVariable("code_emp") Integer code_emp){
            service.delete(code_emp);
        return "redirect:/employe";
    }


}
