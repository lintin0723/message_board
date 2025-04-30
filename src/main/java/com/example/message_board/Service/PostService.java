package com.example.message_board.Service;

import com.example.message_board.Dao.PostRepository;
import com.example.message_board.Entity.Post;
import org.springframework.beans.factory.annotation.Autowired;

public interface PostService {

    Post createPost(Integer id, String context);
}
