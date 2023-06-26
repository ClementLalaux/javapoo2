package com.example.demo.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name="date_todo")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTodo;

    private boolean etat;

    public Todo() {
    }

    public Todo(String titre, String description, Date dateTodo, boolean etat) {
        this.titre = titre;
        this.description = description;
        this.dateTodo = dateTodo;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTodo() {
        return dateTodo;
    }

    public void setDateTodo(Date dateTodo) {
        this.dateTodo = dateTodo;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", dateTodo=" + dateTodo +
                ", etat=" + etat +
                '}';
    }
}
