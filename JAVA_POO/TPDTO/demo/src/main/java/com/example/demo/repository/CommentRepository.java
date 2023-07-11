package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {

    public List<Comment> findAllByIdPost(Integer id);

}
