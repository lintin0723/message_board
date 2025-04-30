package com.example.message_board.Service.Impl;

import com.example.message_board.Dao.UserRepository;
import com.example.message_board.Dto.UserRequest;
import com.example.message_board.Dto.UserResponse;
import com.example.message_board.Entity.User;
import com.example.message_board.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse findUserById(Integer userId) {
        User user = userRepository.findUserById(userId);
        return toResponse(user);
    }

    @Override
    public UserResponse updateUser(Integer userId, User userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setCreatedAt(new Date());

        return toResponse(userRepository.save(user));
    }

    private UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}