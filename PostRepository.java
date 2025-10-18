package com.example.minisocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.minisocial.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {}