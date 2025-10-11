package com.example.db_blog.controller;

import com.example.db_blog.model.Post;
import com.example.db_blog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService svc;
    public PostController(PostService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Post> all() {
        return svc.getAll();
    }

    @GetMapping("/{id")
    public Post get(@PathVariable Long id) {
        return svc.getById(id);
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestParam Long userId, @RequestBody Post post) {
        Post created = svc.create(userId, post);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        return svc.update(id, post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-user/{userId}")
    public List<Post>byUser(@PathVariable Long userId) {
        return svc.findByUser(userId);
    }


}
