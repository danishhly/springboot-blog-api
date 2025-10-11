package com.example.db_blog.respository;

import com.example.db_blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRespository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
