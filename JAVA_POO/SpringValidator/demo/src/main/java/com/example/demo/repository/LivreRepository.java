package com.example.demo.repository;

import com.example.demo.entity.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre,Integer> {
}
