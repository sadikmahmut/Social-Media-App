package com.project.questapp.controllers;

import com.project.questapp.entites.Comment;
import com.project.questapp.requests.CreateCommentRequest;
import com.project.questapp.requests.UpdateCommentRequest;
import com.project.questapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Comment/")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("getAllComments")
    public List<Comment> getAllComments(@RequestParam Optional<Long> PostId){
        return commentService.getAllComments(PostId);
    }

    @GetMapping("getComment/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentService.getComment(id);
    }

    @PostMapping("createComment")
    public Comment createComment(@RequestBody CreateCommentRequest newComment){
        return commentService.createComment(newComment);
    }

    @PutMapping("updateComment")
    public Comment updateComment(@RequestBody UpdateCommentRequest newComment){
        return commentService.updateComment(newComment);
    }

    @DeleteMapping("deleteComment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
