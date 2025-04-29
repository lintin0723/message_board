package com.example.message_board.Service.Impl;

import com.example.message_board.Dao.Impl.UserRepository;
import com.example.message_board.Entity.User;
import com.example.message_board.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}