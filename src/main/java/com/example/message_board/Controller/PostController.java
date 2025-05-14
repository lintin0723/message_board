package com.example.message_board.Controller;

import com.example.message_board.Dto.PostRequest;
import com.example.message_board.Dto.PostResponse;
import com.example.message_board.Entity.Post;
import com.example.message_board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        Post created = postService.createPost(postRequest.getUserId(), postRequest.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId){
        postService.deletePostById(postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> findPostById(@PathVariable Integer postId){
        Post post = postService.findPostById(postId);
        return ResponseEntity.ok(new PostResponse(post));
    }
}
