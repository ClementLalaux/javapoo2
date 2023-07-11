package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 20, message = "La taille du titre est incorrecte")
    private String titre;

    @Max(value = 2023)
    private Integer annee;


    @ManyToOne(cascade = CascadeType.DETACH)
    @NonNull
    private Auteur auteur;

    @ManyToOne(cascade = CascadeType.DETACH)
    @NonNull
    private Genre genre;


}
