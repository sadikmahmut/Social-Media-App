package com.project.questapp.controllers;

import com.project.questapp.entites.Comment;
import com.project.questapp.entites.Like;
import com.project.questapp.requests.CreateCommentRequest;
import com.project.questapp.requests.CreateLikeRequest;
import com.project.questapp.requests.UpdateCommentRequest;
import com.project.questapp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Like/")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("getAllLikes")
    public List<Like> getAllLikes(@RequestParam Optional<Long> PostId){
        return likeService.getAllLikes(PostId);
    }

    @GetMapping("getLike/{id}")
    public Like getLike(@PathVariable Long id){
        return likeService.getLike(id);
    }

    @PostMapping("createLike")
    public Like createLike(@RequestBody CreateLikeRequest newLike){
        return likeService.createLike(newLike);
    }

    @DeleteMapping("deleteLike/{id}")
    public void deleteLike(@PathVariable Long id){
        likeService.deleteLike(id);
    }
}
