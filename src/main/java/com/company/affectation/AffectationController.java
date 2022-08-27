package com.company.affectation;

import com.company.employe.Employe;
import com.company.employe.EmployeService;
import com.company.lieu.Lieu;
import com.company.lieu.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AffectationController {

    @Autowired private AffectationService service;
    @Autowired private EmployeService employeService;
    @Autowired private LieuService lieuService;
    @Autowired private AffectationRepository affectationRepository;
    @GetMapping("/affectation")
    public String lista(Model model){
//        List<Affectation> lista =service.lista();
        List<Affectation> lista =affectationRepository.trouve();
        model.addAttribute("lista",lista);
        System.out.println(lista);
        return "Affectation/list";
    }
    @GetMapping("/affectation/new")
    public String newform(Model model){
        model.addAttribute("affectation",new Affectation());
        List<Employe> employes = employeService.listAll();
        List<Lieu> lieus = lieuService.lista();
        model.addAttribute("employes",employes);
        model.addAttribute("lieus",lieus);
        model.addAttribute("titre","ajout");
        return "Affectation/new";
    }
    @PostMapping("/affectation/save")
    public  String save(Affectation affectation, RedirectAttributes ra){
            service.save(affectation);
        ra.addFlashAttribute("message","insertion affectation a ete succeess");
        return "redirect:/affectation";

    }
    @GetMapping("/affectation/edit/{id}")
    public String editing(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
            try{
                Affectation affectation = service.get(id);
                List<Employe> employes = employeService.listAll();
                List<Lieu> lieus = lieuService.lista();
                model.addAttribute("employes",employes);
                model.addAttribute("lieus",lieus);
                model.addAttribute("affectation",affectation);
                model.addAttribute("titra","modification");
                return "Affectation/new";
            }catch (AffectationNotFoundException e){
                ra.addFlashAttribute("message", e.getMessage());
            }
        return "redirect:/affectation";
    }
    @GetMapping("/affectation/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/affectation";
    }
}
