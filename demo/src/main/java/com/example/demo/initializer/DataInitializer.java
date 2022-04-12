package com.example.demo.initializer;

import com.example.demo.entity.post.Post;
import com.example.demo.dao.PostRepository;
import com.example.demo.entity.user.User;
import com.example.demo.dao.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository, PostRepository postRepository){
//        return args -> {
//            User user = new User("longshin","password123","longshin@Gmail.com","Long shin","VietName",1L,"089997770565",0L,"","https://github.com/longnguyen-2k");
//            List<Post> posts = List.of(new Post("Title post 1","content post 1",1L,"kafka message queue; long-shin-events topic",),new Post("Title post 2","content post 2",1L,"kafka message queue; long-shin-events topic"));
//            postRepository.saveAll(posts);
//            userRepository.save(user);
//        };
//    }
}