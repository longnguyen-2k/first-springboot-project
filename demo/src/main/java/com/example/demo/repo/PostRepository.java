package com.example.demo.repo;

import com.example.demo.models.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("SELECT p from Post where p.user_id= ?1")
//    Optional<Post> findPostByUser(Long user_id);
}
