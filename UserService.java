package com.example.minisocial.service;

import org.springframework.stereotype.Service;
import com.example.minisocial.model.User;
import com.example.minisocial.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }
    public void register(User user) { repo.save(user); }
    public boolean login(String username, String password) {
        User u = repo.findByUsername(username);
        return u != null && u.getPassword().equals(password);
    }
}