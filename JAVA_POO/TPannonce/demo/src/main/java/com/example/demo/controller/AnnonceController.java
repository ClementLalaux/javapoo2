package com.example.demo.controller;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Categorie;
import com.example.demo.services.AnnonceService;
import com.example.demo.services.CategorieService;
import com.example.demo.services.UtilisateurService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    private AnnonceService _annonceService;

    @Autowired
    private CategorieService _categorieService;

    @Autowired
    private UtilisateurService _utilisateurService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession _httpSession;


    @GetMapping("")
    public ModelAndView getAnnonce(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("annonces.html");
        modelAndView.addObject("annonces",_annonceService.getAllAnnonces());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView sortAnnonce(@RequestParam String utilisateur){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("annonces.html");
        try {
            modelAndView.addObject("annonces",_annonceService.getAnnonceByUtilisateur(_utilisateurService.findById(Integer.parseInt(utilisateur))));
        } catch (Exception e) {
            modelAndView.addObject("annonces",_annonceService.getAllAnnonces());
        }

        return modelAndView;
    }

    @GetMapping("add")
    public ModelAndView getFormAnnonce(){
        ModelAndView modelAndView = new ModelAndView();
        Annonce annonce1 = new Annonce();
        modelAndView.setViewName("annonce-form.html");
        modelAndView.addObject("annonce",annonce1);
        modelAndView.addObject("categories",_categorieService.getAllCategories());
        return modelAndView;
    }

    @PostMapping("form-add")
    public ModelAndView submitAnnonce(@RequestParam String titre, @RequestParam String description, @RequestParam Double prix, @RequestParam(required=false) List<String> categories, @RequestParam("images") List<MultipartFile> images,@PathVariable(name="id",required=false) Integer id ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("annonce-form.html");
        if (!_utilisateurService.isLogged()) {
            return modelAndView;
        } else {
            List<Categorie> categories1 = new ArrayList<>();
            for (String s : categories) {
                if (_categorieService.findById(Integer.parseInt(s)) != null) {
                    categories1.add(_categorieService.findById(Integer.parseInt(s)));
                }
            }
            try {
                if(_annonceService.findById(id) == null){
                    _annonceService.createAnnonce(titre, description, prix,Integer.parseInt(_httpSession.getAttribute("idUtilisateur").toString()) , categories1, images);
                    return modelAndView;
                } else {
                    Annonce annonce = _annonceService.findById(id);
                    annonce.setTitre(titre);
                    annonce.setDescription(description);
                    annonce.setPrix(prix);
                    if(_annonceService.updateAnnonce(annonce)){
                        return modelAndView;
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String editAnnonce(@PathVariable Integer id, Model model) {
        Annonce annonce = _annonceService.findById(id);
        model.addAttribute("categories",_categorieService.getAllCategories());
        model.addAttribute("annonce", annonce);
        return "annonce-form";
    }


}
