package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateTournoi;



}
