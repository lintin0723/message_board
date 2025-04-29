package com.example.message_board.Dao.Impl;

import com.example.message_board.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(Integer userId);
}
