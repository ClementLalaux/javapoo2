package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/post/{id}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("comment")
    public ResponseEntity<List<Comment>> get(@PathVariable Integer id){
        List<Comment> response = commentService.findAllByIdPost(id);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("comment/{comment_id}")
    public ResponseEntity<Comment> get(@PathVariable Integer id , @PathVariable int comment_id){
        Comment comment = commentService.findById(comment_id);
        if(comment == null){
            return ResponseEntity.notFound().build();
        }
        if(!Objects.equals(comment.getIdPost().getId(), id)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(comment);
    }

    @PutMapping("comment/{comment_id}")
    public ResponseEntity<Comment> update(@PathVariable Integer id , @PathVariable int comment_id, @RequestBody Comment update){
        Comment comment = commentService.findById(comment_id);
        Post post = postService.findById(id);
        if(comment == null || post == null){
            return ResponseEntity.notFound().build();
        } else {
            comment.setName(update.getName());
            comment.setBody(update.getBody());
            comment.setEmail(update.getEmail());
            comment.setIdPost(update.getIdPost());
            commentService.save(comment);
            return ResponseEntity.ok(comment);
        }
    }

    @PostMapping("comment")
    public ResponseEntity<Comment> post(@PathVariable Integer id, @RequestBody Comment comment){
        Post post = postService.findById(id);
        if(post == null){
            return ResponseEntity.notFound().build();
        } else {
            post.getComments().add(comment);
            comment.setIdPost(post);
            Comment comment1 = commentService.save(comment);
            return ResponseEntity.ok(comment1);
        }
    }

}
