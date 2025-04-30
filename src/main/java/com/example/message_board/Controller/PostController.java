package com.example.message_board.Controller;

import com.example.message_board.Dto.PostRequest;
import com.example.message_board.Entity.Post;
import com.example.message_board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        Post created = postService.createPost(postRequest.getUserId(), postRequest.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
