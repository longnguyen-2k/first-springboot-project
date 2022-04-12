package com.example.demo.controller;

import com.example.demo.models.post.Post;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public String getPost(Model model){
        model.addAttribute("posts",postService.getPosts());
        return "view-posts";
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post createPost(@RequestBody  Post post){
        this.kafkaTemplate.send("shin-events",post.getMessage());
        return  postService.createPost(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

    @PutMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long postId,@RequestParam(required = false) String title, @RequestParam(required = false) String content,@RequestParam(required = true) Long user_id){
        postService.updatePost(postId,title,content,user_id);
    }
}
