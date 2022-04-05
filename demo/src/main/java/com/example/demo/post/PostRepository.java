package com.example.demo.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    @Query("SELECT p from Post where p.user_id= ?1")
//    Optional<Post> findPostByUser(Long user_id);
}
