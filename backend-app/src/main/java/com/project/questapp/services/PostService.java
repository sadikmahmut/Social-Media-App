package com.project.questapp.services;

import com.project.questapp.entites.Post;
import com.project.questapp.entites.User;
import com.project.questapp.repositories.PostRepository;
import com.project.questapp.requests.CreatePostRequest;
import com.project.questapp.requests.UpdatePostRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts (Optional <Long> UserId){
        if(UserId.isPresent()){
            return postRepository.findByUserId(UserId.get());
        } else return postRepository.findAll();
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(CreatePostRequest newPost){
        User user = userService.getUser(newPost.getUserId());
        if(user == null)
            return null;
        Post post = new Post(user, newPost.getTitle(), newPost.getText());
        return postRepository.save(post);
    }

    public Post updatePost(UpdatePostRequest newPost){
         Optional<Post> post = postRepository.findById(newPost.getId());
         if(post.isPresent()){
             Post foundPost = post.get();
             foundPost.setText(newPost.getText());
             foundPost.setTitle(newPost.getTitle());
             postRepository.save(foundPost);
             return foundPost;
         } else return null;
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
