package com.example.demo.repository;

import com.example.demo.entity.Auteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends CrudRepository<Auteur,Integer> {
}
