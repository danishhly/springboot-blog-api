package com.example.db_blog.service;

import com.example.db_blog.exception.ResourceNotFoundException;
import com.example.db_blog.model.User;
import com.example.db_blog.respository.UserRespository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRespository userRespository;
    public UserService(UserRespository repo) {
        this.userRespository = repo;
    }

    public List<User> getAll() {
        return userRespository.findAll(); }
    public User getById(Long id) {
        return userRespository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id" + id));
    }
    public User create(User user) {
        return userRespository.save(user);
    }
    public User update(Long id, User u) {
        User user = getById(id);
        user.setUsername(u.getUsername());
        user .setEmail(u.getEmail());
        return userRespository.save(user);
    }
    public void delete(Long id) {
        userRespository.delete(getById(id));
    }

}
