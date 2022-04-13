package com.example.demo.controller;

import com.example.demo.entity.post.Post;
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
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPost(@RequestParam(required = false)Integer offset,@RequestParam(required = false)Integer limit){
//        model.addAttribute("posts",postService.getPosts());
//        return "view-posts";
        Logger logger
                = Logger.getLogger(
                PostController.class.getName());
        logger.log(Level.INFO,"Thí is Log "+String.valueOf(limit));
        return  postService.getPostsPaginate(offset!=null?offset:1,limit!=null?limit:20);
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
