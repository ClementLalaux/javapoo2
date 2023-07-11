package com.example.demo.controller;


import com.example.demo.entity.Auteur;
import com.example.demo.service.AuteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auteur")
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    @PostMapping("/add")
    ResponseEntity<String> addAuteur(@Valid @RequestBody Auteur auteur){
        auteurService.save(auteur);
        return ResponseEntity.ok("Auteur crée");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auteur> getAuteur(@PathVariable Integer id){
        Auteur auteur = auteurService.findById(id);
        return ResponseEntity.ok(auteur);
    }

    @GetMapping("")
    public ResponseEntity<List<Auteur>> getAuteurs(){
        List<Auteur> auteurs = auteurService.findAll();
        return ResponseEntity.ok(auteurs);
    }

}
