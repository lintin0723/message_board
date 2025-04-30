package com.example.message_board.Service.Impl;

import com.example.message_board.Dao.PostRepository;
import com.example.message_board.Dao.UserRepository;
import com.example.message_board.Entity.Post;
import com.example.message_board.Entity.User;
import com.example.message_board.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Integer id, String context) {
        User user = userRepository.findUserById(id);

        Post post = new Post();
        post.setUser(user);
        post.setContent(context);
        post.setCreatedAt(new Date());

        return postRepository.save(post);
    }
}
