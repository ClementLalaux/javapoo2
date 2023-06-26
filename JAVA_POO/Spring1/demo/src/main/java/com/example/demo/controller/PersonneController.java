package com.example.demo.controller;

import com.example.demo.entity.Personne;
import com.example.demo.service.impl.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class PersonneController {

    @Autowired
    private PersonneServiceImpl _personneServiceImpl;

    public PersonneController(){

    }

    @GetMapping("/personne")
    public String getAllPersonne(){
        String retour = "";
        for (Personne p : _personneServiceImpl.getAllPersonne()) {
            retour += "Nom " + p.getNom() + " , Prenom " + p.getPrenom();
        }
        return retour;
    }

    @GetMapping("/personne/{data}")
    public String getData(@PathVariable("data") Integer id){
        String retour = "";
        for (Personne p : _personneServiceImpl.getAllPersonne()) {
            if(p.getId() == id){
                retour += "Id : " + id + " , Nom " + p.getNom() + " , Prenom " + p.getPrenom();
            }
        }
        return retour;
    }

    @PostMapping("/add")
    public String addData(@RequestBody Personne personne){

        return personne.getNom() + " , " + personne.getPrenom();
    }

}
