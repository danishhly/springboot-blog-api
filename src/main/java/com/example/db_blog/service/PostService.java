package com.example.db_blog.service;

import com.example.db_blog.model.Post;
import com.example.db_blog.model.User;
import com.example.db_blog.respository.PostRespository;
import com.example.db_blog.respository.UserRespository;
import com.example.db_blog.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    private final PostRespository postRespository;
    private final UserRespository userRespository;

    public PostService(PostRespository pr, UserRespository ur) {
        this.postRespository = pr;
        this.userRespository = ur;
    }

    public List<Post> getAll() {
        return postRespository.findAll();
    }

    public Post getById(Long id) {
        return postRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id" + id));
    }

    public Post create(Long userId, Post post) {
        User user = userRespository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id" + userId));
        post.setAuthor(user);
        return postRespository.save(post);
    }
        public Post update(Long id, Post updated) {
            Post post = getById(id);
            post.setTitle(updated.getTitle());
            post.setContent(updated.getContent());
            return postRespository.save(post);
        }

        public void delete(Long id) {
        postRespository.delete(getById(id));
        }

        public List<Post> findByUser(Long userId) {
        return postRespository.findByAuthorId(userId);
        }
    }

