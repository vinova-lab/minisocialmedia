package com.example.minisocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.minisocial.model.Post;
import com.example.minisocial.model.Comment;
import com.example.minisocial.service.PostService;

@Controller
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) { this.postService = postService; }

    @GetMapping("/feed")
    public String feed(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "index";
    }

    @PostMapping("/post")
    public String addPost(@RequestParam String content, @RequestParam String author) {
        postService.addPost(new Post(content, author));
        return "redirect:/feed";
    }

    @PostMapping("/like/{id}")
    public String like(@PathVariable Long id) {
        postService.likePost(id);
        return "redirect:/feed";
    }

    @PostMapping("/comment/{id}")
    public String comment(@PathVariable Long id, @RequestParam String author, @RequestParam String text) {
        postService.addComment(id, new Comment(author, text));
        return "redirect:/feed";
    }
}