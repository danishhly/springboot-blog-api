package com.example.db_blog.controller;

import com.example.db_blog.model.Comment;
import com.example.db_blog.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class CommentController {
    private final CommentService svc;
    public CommentController(CommentService svc) { this.svc = svc; }

    @GetMapping
    public List<Comment> all() { return svc.getAll(); }

    @GetMapping("/{id}")
    public Comment get(@PathVariable Long id) { return svc.getById(id); }

    // Create comment for a post: POST /api/comments?postId=5
    @PostMapping
    public ResponseEntity<Comment> create(@RequestParam Long postId, @RequestBody Comment comment) {
        Comment created = svc.create(postId, comment);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) { return svc.update(id, comment); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { svc.delete(id); return ResponseEntity.noContent().build(); }

    @GetMapping("/by-post/{postId}")
    public List<Comment> byPost(@PathVariable Long postId) { return svc.findByPost(postId); }
}

