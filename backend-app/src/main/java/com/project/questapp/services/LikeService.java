package com.project.questapp.services;

import com.project.questapp.entites.Comment;
import com.project.questapp.entites.Like;
import com.project.questapp.entites.Post;
import com.project.questapp.entites.User;
import com.project.questapp.repositories.LikeRepository;
import com.project.questapp.requests.CreateLikeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLikes(Optional<Long> PostId) {
        if(PostId.isPresent()){
            return likeRepository.findAllByPostId(PostId.get());
        } else return likeRepository.findAll();
    }

    public Like getLike(Long id) {
        return likeRepository.findById(id).orElse(null);
    }

    public Like createLike(CreateLikeRequest newLike) {
        Post post = postService.getPost(newLike.getPostId());
        User user = userService.getUser(newLike.getUserId());

        if(post != null && user != null){
            Like like = new Like(post, user);
            return likeRepository.save(like);
        }else return null;
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
