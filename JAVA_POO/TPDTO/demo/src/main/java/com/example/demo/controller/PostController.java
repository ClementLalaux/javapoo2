package com.example.demo.controller;
;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<List<Post>> get(){
        return ResponseEntity.ok((List<Post>) postService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> get(@PathVariable Integer id){
        Post post = postService.findById(id);
        if(post == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping("")
    public ResponseEntity<Post> post(@RequestBody Post post){
        Post post1 = postService.save(post);
        if(post1 != null){
            return ResponseEntity.ok(post1);
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
