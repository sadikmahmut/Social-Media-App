package com.project.questapp.repositories;

import com.project.questapp.entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long UserId);
}
