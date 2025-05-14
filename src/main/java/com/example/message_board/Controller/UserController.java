package com.example.message_board.Controller;

import com.example.message_board.Dto.UserRequest;
import com.example.message_board.Dto.UserResponse;
import com.example.message_board.Entity.User;
import com.example.message_board.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId){
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @PutMapping("users/{userId}")
    public ResponseEntity<UserResponse> ChangeInfo(@PathVariable Integer userId,
                                                   @RequestBody User userRequest){
        return ResponseEntity.ok(userService.updateUser(userId,userRequest));
    }
}
