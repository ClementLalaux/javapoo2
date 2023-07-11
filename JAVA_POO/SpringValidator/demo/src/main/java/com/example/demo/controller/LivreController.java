package com.example.demo.controller;

import com.example.demo.entity.Genre;
import com.example.demo.entity.Livre;
import com.example.demo.service.GenreService;
import com.example.demo.service.LivreService;
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
@RequestMapping("/api/livre")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @PostMapping("/add")
    ResponseEntity<String> addLivre(@Valid @RequestBody Livre livre){
        livreService.save(livre);
        return ResponseEntity.ok("Livre crée");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivre(@PathVariable Integer id){
        Livre livre = livreService.findById(id);
        return ResponseEntity.ok(livre);
    }

    @GetMapping("")
    public ResponseEntity<List<Livre>> getGenres(){
        List<Livre> livres = livreService.findAll();
        return ResponseEntity.ok(livres);
    }

}
