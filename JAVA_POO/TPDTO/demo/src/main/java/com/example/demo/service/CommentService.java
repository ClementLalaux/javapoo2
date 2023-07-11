package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(Integer id);

    Comment save(Comment comment);

    void deleteById(Integer id);

    List<Comment> findAllByIdPost(Integer id);
}
