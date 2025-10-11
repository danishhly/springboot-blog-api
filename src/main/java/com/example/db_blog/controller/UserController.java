package com.example.db_blog.controller;

import com.example.db_blog.model.User;
import com.example.db_blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService svc;
    public UserController(UserService s) {
        this.svc = s;
    }

    @GetMapping
    public List<User> all() {
        return svc.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return svc.getById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User created = svc.create(user);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return svc.update(id, user);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }

    }

