package com.example.demo.services;

import com.example.demo.entities.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {
    boolean create(Todo t);
    boolean update(Todo t);

    boolean delete(Todo t);

    Optional<Todo> findById(int id);

    List<Todo> findAll();
}
