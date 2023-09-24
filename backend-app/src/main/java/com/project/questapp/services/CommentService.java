package com.project.questapp.services;

import com.project.questapp.entites.Comment;
import com.project.questapp.entites.Post;
import com.project.questapp.entites.User;
import com.project.questapp.repositories.CommentRepository;
import com.project.questapp.requests.CreateCommentRequest;
import com.project.questapp.requests.UpdateCommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    private final UserService userService;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Long> PostId) {
        if(PostId.isPresent()){
            return commentRepository.findAllByPostId(PostId.get());
        } else return commentRepository.findAll();
    }

    public Comment getComment(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(CreateCommentRequest newComment){
        User user = userService.getUser(newComment.getUserId());
        Post post = postService.getPost(newComment.getPostId());
        if(user != null && post != null){
            Comment comment = new Comment(post, user, newComment.getText());
            return commentRepository.save(comment);
        }else return null;
    }


    public Comment updateComment(UpdateCommentRequest newComment) {
        Optional<Comment> comment = commentRepository.findById(newComment.getId());
        if(comment.isPresent()){
            Comment foundComment = comment.get();
            foundComment.setText(newComment.getText());
            commentRepository.save(foundComment);
            return foundComment;
        } else return null;
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
