package com.example.db_blog.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

 @Entity
 @Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
     private String content;

    @Column(nullable = false)
     private String authorName;

    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "post_id")
     @JsonBackReference
     private Post post;

    public Comment() {}
     public Comment(String content, String authorName) {
        this.content = content;
        this.authorName = authorName;
     }

     public Long getId() { return id; }
     public String getContent() { return content; }
     public void setContent(String content) { this.content = content; }
     public String getAuthorName() { return authorName; }
     public void setAuthorName(String authorName) { this.authorName = authorName; }
     public Post getPost() { return post; }
     public void setPost(Post post) { this.post = post; }

 }

