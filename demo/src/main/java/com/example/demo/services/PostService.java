package com.example.demo.services;

import com.example.demo.models.post.Post;
import com.example.demo.repo.PostRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository repository, UserRepository userRepository) {
        this.postRepository = repository;
        this.userRepository = userRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        boolean isExist = userRepository.existsById(post.getUser_id());
        if (!isExist){
            throw  new IllegalStateException("User not found");
        }
        return  postRepository.save(post);
    }

    public void deletePost(Long postId) {
        boolean ifExists = postRepository.existsById(postId);
        if (!ifExists) {
            throw new IllegalStateException("post not found by id: " + postId);
        }
        postRepository.deleteById(postId);
    }

    @Transactional
    public void updatePost(Long postId, String title, String content,Long user_id) {
        Post post = postRepository.findById(postId).orElseThrow(()->new IllegalStateException("Post with id "+ postId+ " does not exist"));

        if (user_id!=post.getUser_id()){
            throw new IllegalStateException("User are not owner post of id "+postId);
        }

        if (!title.isEmpty()&&!title.isBlank()&& Objects.equals(post.getTitle(), title)){
            post.setTitle(title);
        }
        if (!content.isEmpty()&&!content.isBlank()&& Objects.equals(post.getContent(), content)){
            post.setContent(content);
        }
    }

}
