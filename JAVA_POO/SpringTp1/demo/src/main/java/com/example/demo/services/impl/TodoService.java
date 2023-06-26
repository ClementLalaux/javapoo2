package com.example.demo.services.impl;

import com.example.demo.entities.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.services.ITodoService;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    private TodoRepository _todoRepository;

    public TodoService(TodoRepository todoRepository){
        _todoRepository = todoRepository;
    }

    @Override
    public boolean create(Todo t) {
        _todoRepository.save(t);
        return t.getId()>0;
    }

    @Override
    public boolean update(Todo t) {
        _todoRepository.save(t);
        return t.getId()>0;
    }

    @Override
    public boolean delete(Todo t) {
        _todoRepository.delete(t);
        return t.getId()>0;
    }

    @Override
    public Optional<Todo> findById(int id) {
        return _todoRepository.findById(id);
    }

    @Override
    public List<Todo> findAll() {
        return (List<Todo>) _todoRepository.findAll();
    }

    public List<Todo> findEnded(boolean etat){
        return (List<Todo>) _todoRepository.findByEtat(etat);
    }


}
