package com.example.demo.post;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,PostRepository postRepository){
        return args -> {
            Post post = new Post("Title","Content",1L);
            postRepository.save(post);
            User user = new User("longshin","longshin@Gmail.com","Long Nguyen","password");
            userRepository.save(user);
        };
    }
}