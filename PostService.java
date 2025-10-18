package com.example.minisocial.service;

import org.springframework.stereotype.Service;
import com.example.minisocial.model.Post;
import com.example.minisocial.model.Comment;
import com.example.minisocial.repository.PostRepository;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repo;
    public PostService(PostRepository repo) { this.repo = repo; }
    public List<Post> getAll() { return repo.findAll(); }
    public Post addPost(Post p) { return repo.save(p); }
    public void likePost(Long id) {
        repo.findById(id).ifPresent(p -> { p.like(); repo.save(p); });
    }
    public void addComment(Long postId, Comment c) {
        repo.findById(postId).ifPresent(p -> { p.addComment(c); repo.save(p); });
    }
}