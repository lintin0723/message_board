package com.example.message_board.Dto;

import org.springframework.data.relational.core.sql.In;

public class PostRequest {
    private Integer id;
    private String content;
    private Integer userId;

    public Integer getId(){return id;}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
