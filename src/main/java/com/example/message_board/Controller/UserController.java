package com.example.message_board.Controller;

import com.example.message_board.Entity.User;
import com.example.message_board.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUserById(userId);
    }

    @GetMapping("user/{userId}")
    public User CheckUser(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    @PutMapping("user/{userId}")
    public User ChangeInfo(@PathVariable Integer userId, @RequestBody User userRequest){
        return userService.updateUser(userId,userRequest);
    }
}
