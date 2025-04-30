package com.example.message_board.Service;

import com.example.message_board.Dto.UserRequest;
import com.example.message_board.Dto.UserResponse;
import com.example.message_board.Entity.User;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    void deleteUserById(Integer userId);
    UserResponse findUserById(Integer userId);
    UserResponse updateUser(Integer userId, User userRequest);
}
