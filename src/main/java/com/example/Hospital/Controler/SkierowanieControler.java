package com.example.Hospital.Controler;

import com.example.Hospital.model.SkierowanieDoLekarza;
import com.example.Hospital.service.SkierowanieServis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/skierowanie")
public class SkierowanieControler {
    SkierowanieServis service;

    public SkierowanieControler(SkierowanieServis service) {
        this.service = service;
    }

    @GetMapping("/list") //skierowanie/list i to skieruje do lis-skierowanie.html
    public String listSkierowanie(Model model) {
        model.addAttribute("skierowania", service.listSkierowanie());
        return "list-skierowanie";
    }

    @GetMapping("/{id}")
    public String getSkierowanie(@PathVariable Integer id, Model model) throws Exception {
        SkierowanieDoLekarza skierowanieDoLekarza = service.getSkierowanie(id);
        model.addAttribute("skierowanie", skierowanieDoLekarza);
        return "get-skierowanie";
    }
    @GetMapping("/dodaj")
    public String dodajSkierowanie(Model model) {
        model.addAttribute("skierowanie", new SkierowanieDoLekarza());
        return "dodaj-skierowanie";
    }
    @PostMapping("/dodaj")
    public String stworzSkierowanie(
                                    @Valid
                                    @ModelAttribute SkierowanieDoLekarza skierowanieDoLekarza,
                                    Model model,
                                    BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "dodaj-skierowanie";
        }
        service.createSkierowanie(skierowanieDoLekarza);
        return "redirect:/skierowanie/list";
    }
    @GetMapping("/modyfikuj/{id}")
    public String modyfikujSkierowanie(@PathVariable Integer id, Model model) throws Exception {
    model.addAttribute("skierowanie", service.getSkierowanie(id));
    return "modyfikuj-skierowanie";
    }
    @PutMapping("/modyfikuj")
    public String updateSkierowanie(
            @Valid
            @ModelAttribute
                    SkierowanieDoLekarza skierowanieDoLekarza,
            Model model, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "modyfikuj-skierowanie";
        }
        service.updateSkierowanie(skierowanieDoLekarza);
        return "redirect:/skierowanie" + skierowanieDoLekarza.getId();
        //lub zapisać jako String.format("redirect:/skierowanie/%d", skierowanieDoLekarza.getId())
    }

    @GetMapping("/usun/{id}")
    public String usunSkierowanie(@PathVariable Integer id) {
        service.deleteSkierowanie(id);
        return "redirect:/skierowanie/list";
    }
}
