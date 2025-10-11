package com.example.db_blog.respository;

import com.example.db_blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRespository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorId(Long authorId);
}
