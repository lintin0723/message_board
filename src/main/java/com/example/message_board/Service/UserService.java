package com.example.message_board.Service;

import com.example.message_board.Entity.User;

public interface UserService {
    User createUser(User user);
    void deleteUserById(Integer userId);
    User getUserById(Integer userId);
    User updateUser(Integer userId, User userRequest);
}
