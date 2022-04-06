package com.example.demo.config;

import com.example.demo.models.post.Post;
import com.example.demo.repo.PostRepository;
import com.example.demo.models.user.User;
import com.example.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PostConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PostRepository postRepository){
        return args -> {
            User user = new User("longshin","longshin@Gmail.com","Long Nguyen","password");
            List<Post> posts = List.of(new Post("Title post 1","content post 1",1L),new Post("Title post 2","content post 2",1L));
            postRepository.saveAll(posts);
            userRepository.save(user);
        };
    }
}