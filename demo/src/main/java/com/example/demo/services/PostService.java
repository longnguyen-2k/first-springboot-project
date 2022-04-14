package com.example.demo.services;

import com.example.demo.controller.PostController;
import com.example.demo.entity.post.Post;
import com.example.demo.dao.PostRepository;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository repository, UserRepository userRepository) {
        this.postRepository = repository;
        this.userRepository = userRepository;
    }

    public List<Post> getPostsPaginate(int offset, int limit) {

        Pageable paging = PageRequest.of(offset,limit);
        Page<Post>  result = postRepository.findAll(paging);
        Logger logger
                = Logger.getLogger(
                PostService.class.getName());
        logger.log(Level.WARNING, "This is Log " + result);

        return result.toList();
    }

    public Post createPost(Post post) {
        boolean isExist = userRepository.existsById(post.getUserId());
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
    public void updatePost(Long postId, String title, String content,Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(()->new IllegalStateException("Post with id "+ postId+ " does not exist"));

        if (userId!=post.getUserId()){
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
