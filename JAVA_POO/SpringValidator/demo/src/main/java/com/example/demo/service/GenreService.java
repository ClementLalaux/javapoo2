package com.example.demo.service;

import com.example.demo.entity.Auteur;
import com.example.demo.repository.GenreRepository;
import com.example.demo.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void save(Genre genre){
        genreRepository.save(genre);
    }
    public Genre findById(Integer id){
        return genreRepository.findById(id).get();
    }

    public List<Genre> findAll(){
        return (List<Genre>) genreRepository.findAll();
    }

    public Genre updateGenre(Integer id, Genre genre){
        Genre genreUpdate = genreRepository.findById(id).get();
        genreUpdate.setNom(genre.getNom());
        genreUpdate.setDescription(genre.getDescription());
        return genreRepository.save(genreUpdate);
    }

    public void deleteGenre(Integer id){
        Genre genreDelete = genreRepository.findById(id).get();
        genreRepository.delete(genreDelete);
    }


}
