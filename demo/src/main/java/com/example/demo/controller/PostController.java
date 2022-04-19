package com.example.demo.controller;

import com.example.demo.entity.post.Post;
import com.example.demo.services.post.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postServiceImpl;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public List<Post> getPost(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        if (offset == null || offset < 0) {
            offset = 0;
        }
        if (limit == null || limit < 20) {
            limit = 20;
        }
        if (offset!=null && limit!=null)
            return postServiceImpl.gets(offset, limit);
        else
            return postServiceImpl.gets();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        this.kafkaTemplate.send("shin-events", post.getMessage());
        return postServiceImpl.create(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postServiceImpl.delete(postId);
    }

    @PutMapping(path = "{postId}")
    public Post updatePost(  @PathVariable("postId") Long postId,@RequestBody Post post) {
       return postServiceImpl.update(postId,post);
    }
}
