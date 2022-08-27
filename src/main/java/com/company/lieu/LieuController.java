package com.company.lieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LieuController {
    @Autowired private LieuService service;

    @GetMapping("/lieu")
    public String listLieu(Model model){
        List<Lieu> listLieu = service.lista();
        model.addAttribute("listLieu",listLieu);
        return "Lieu/list";
    }

    @GetMapping("/lieu/new")
    public String newform(Model model){
        model.addAttribute("lieu", new Lieu());
        model.addAttribute("titre", "ajout Lieu");
        return "Lieu/new";
    }
    @PostMapping("/lieu/save")
    public String save(Lieu lieu, RedirectAttributes ra){
        service.save(lieu);
        ra.addFlashAttribute("message","votre mise a jour a ete success");
        return "redirect:/lieu";
    }
    @GetMapping("/lieu/edit/{code_lieu}")
    public String editing(@PathVariable("code_lieu") Integer code_lieu,Model model,RedirectAttributes ra){
        try{
            Lieu lieu = service.get(code_lieu);
            model.addAttribute("lieu", lieu);
            model.addAttribute("titre","modification du lieu");
            return "lieu/new";
        }catch (LieuNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/lieu";
        }
    }

    @GetMapping("/lieu/delete/{code_lieu}")
    public String delete(@PathVariable("code_lieu") Integer code_lieu){
        service.delete(code_lieu);
        return "redirect:/lieu";
    }


}
