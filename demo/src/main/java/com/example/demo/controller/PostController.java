package com.example.demo.controller;

import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.services.PostService;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RestController
@RequestMapping(path = "api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPost(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        if (offset == null || offset < 0) {
            offset = 0;
        }
        if (limit == null || limit < 20) {
            limit = 20;
        }
        return postService.gets(offset, limit);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        this.kafkaTemplate.send("shin-events", post.getMessage());
        return postService.create(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.delete(postId);
    }

    @PutMapping(path = "{postId}")
    public Post updatePost(  @PathVariable("postId") Long postId,@RequestBody Post post) {
       return postService.update(postId,post);
    }
}
