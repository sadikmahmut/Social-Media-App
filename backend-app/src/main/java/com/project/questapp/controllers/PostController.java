package com.project.questapp.controllers;

import com.project.questapp.entites.Post;
import com.project.questapp.requests.CreatePostRequest;
import com.project.questapp.requests.UpdatePostRequest;
import com.project.questapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Post/")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("getAllPosts")
    public List<Post> getAllPosts(@RequestParam Optional<Long> UserId){
        return postService.getAllPosts(UserId);
    }

    @GetMapping("getPost/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PostMapping("createPost")
    public Post createPost(@RequestBody CreatePostRequest newPost){
        return postService.createPost(newPost);
    }

    @PutMapping("updatePost")
    public Post updatePost(@RequestBody UpdatePostRequest newPost){
        return postService.updatePost(newPost);
    }

    @DeleteMapping("deletePost/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
