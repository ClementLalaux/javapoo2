package com.example.demo.controller;

import com.example.demo.entity.Auteur;
import com.example.demo.entity.Genre;
import com.example.demo.service.AuteurService;
import com.example.demo.service.GenreService;
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
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/add")
    ResponseEntity<String> addGenre(@Valid @RequestBody Genre genre){
        genreService.save(genre);
        return ResponseEntity.ok("Genre crée");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Integer id){
        Genre genre = genreService.findById(id);
        return ResponseEntity.ok(genre);
    }

    @GetMapping("")
    public ResponseEntity<List<Genre>> getGenres(){
        List<Genre> genres = genreService.findAll();
        return ResponseEntity.ok(genres);
    }

}
