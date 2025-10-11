package com.example.db_blog.service;

import com.example.db_blog.model.Comment;
import com.example.db_blog.model.Post;
import com.example.db_blog.respository.CommentRespository;
import com.example.db_blog.respository.PostRespository;
import com.example.db_blog.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    private final CommentRespository commentRespository;
    private final PostRespository postRespository;

    public CommentService(CommentRespository cr, PostRespository pr) {
        this.commentRespository = cr;
        this.postRespository = pr;
    }

    public List<Comment> getAll() {
        return commentRespository.findAll();
    }
        public Comment getById(Long id) {
            return commentRespository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id" + id));
    }

    public Comment create(Long postId, Comment comment) {
        Post post = postRespository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with the id" + postId));
        comment.setPost(post);
        return commentRespository.save(comment);
    }

    public Comment update(Long id, Comment updated){
        Comment comment = getById(id);
        comment.setContent(updated.getContent());
        comment.setAuthorName(updated.getAuthorName());
        return commentRespository.save(comment);
    }

    public void delete(Long id) {
        commentRespository.delete(getById(id));
    }

    public List<Comment> findByPost(Long postId) {
        return commentRespository.findByPostId(postId);
    }
}
