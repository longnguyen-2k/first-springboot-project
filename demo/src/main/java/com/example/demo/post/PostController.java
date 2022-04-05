package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPost(){
        return postService.getPosts();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post createPost(@RequestBody  Post post){
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
