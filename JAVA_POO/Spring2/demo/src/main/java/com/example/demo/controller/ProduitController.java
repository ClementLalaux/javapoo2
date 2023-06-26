package com.example.demo.controller;


import com.example.demo.entities.Produit;
import com.example.demo.services.impl.ProduitService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @GetMapping("/affiche")
    public ModelAndView getListProduit(){

        ModelAndView modelAndView = new ModelAndView();

        if(produitService.findAll().isEmpty()){
            modelAndView.setViewName("error");
        }else{
            modelAndView.setViewName("produits");
            modelAndView.addObject("produits",produitService.findAll());
        }
        return modelAndView;
    }

    @PostMapping("/affiche")
    public ModelAndView traitement(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Integer valeur = Integer.parseInt(request.getParameter("produit"));
        if(produitService.findById(valeur) != null){
            modelAndView.setViewName("produit");
            modelAndView.addObject("produit",produitService.findById(valeur));
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @GetMapping("/affiche/{id}")
    public String getData(@PathVariable("id") Integer id){
        String retour = "";
        Produit p = produitService.findById(id);
        if(p != null) {
            retour += "Id : " + id + " , Reference " + p.getReference() + " , Marque " + p.getMarque();
        }

        return retour;
    }

    @GetMapping("/formulaire")
    public ModelAndView formulaire(){
        ModelAndView modelAndView = new ModelAndView();
        Produit produitVide = new Produit();
        modelAndView.addObject("produitVide",produitVide);
        modelAndView.setViewName("formulaire");
        return modelAndView;
    }

    @PostMapping("/formulaire")
    public ModelAndView postFormulaire(@ModelAttribute Produit produit ){
        ModelAndView modelAndView = new ModelAndView();
        produitService.create(produit);
        modelAndView.setViewName("produits");
        return modelAndView;
    }

    @DeleteMapping("/produit/delete/{id}")
    public String deleteData(@PathVariable("id") Integer id) throws Exception {
        String retour = "";
        Produit p = produitService.findById(id);
        if(p != null) {
            produitService.delete(p);
            retour += "Produit avec id : " + id +" supprimé";
        } else {
            retour = "Erreur";
            throw new Exception();
        }
        return retour;
    }

    @PutMapping("/produit/put")
    public String updateData(@RequestBody Produit produit) throws Exception {
        String retour = "";
        Produit p = produitService.findById(produit.getId());
        if(p != null) {
            p.setDateAchat(produit.getDateAchat());
            p.setMarque(produit.getMarque());
            p.setPrix(produit.getPrix());
            p.setReference(produit.getReference());
            p.setStock(produit.getStock());
            produitService.update(p);
            retour += "Produit avec id : " + produit.getId() +" modifié";
        } else {
            throw new Exception();
        }
        return retour;
    }

}
