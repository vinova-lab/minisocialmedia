package com.example.minisocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.minisocial.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}