package com.example.message_board.Dto;

import com.example.message_board.Entity.Post;

import java.util.Date;

public class PostResponse {
    private Integer id;
    private String content;
    private String username;
    private Date createdAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
