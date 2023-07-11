package com.example.demo.service;

import com.example.demo.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(Integer id);

    Post save(Post post);

    void deleteById(Integer id);

}
