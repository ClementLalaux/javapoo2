package com.example.demo.controller;

import com.example.demo.entities.Categorie;
import com.example.demo.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("")
    public ModelAndView getCategorieView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categorie-form.html");
        return modelAndView;
    }

    @PostMapping("ajout")
    public ModelAndView addCategorie(@RequestParam String titre) throws Exception {
        ModelAndView modelAndView = new ModelAndView("categorie-form");
        List<Categorie> categories = categorieService.getAllCategories();
        boolean isCategorieExist = false;
        if(titre == null){
            throw new Exception("Les champs ne sont pas corrects");
        }
        for (Categorie c: categories) {
            if(c.getNom().equals(titre)){
                isCategorieExist = true;
            }
        }
        if(isCategorieExist == false){
            try {
                Categorie categorie1 = categorieService.createCategorie(titre);
                return modelAndView;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
