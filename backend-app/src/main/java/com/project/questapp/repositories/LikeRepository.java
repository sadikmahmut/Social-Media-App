package com.project.questapp.repositories;

import com.project.questapp.entites.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {

    List<Like> findAllByPostId(Long PostId);
}
