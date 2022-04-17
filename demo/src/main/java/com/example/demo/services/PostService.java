package com.example.demo.services;

import com.example.demo.entity.post.Post;
import com.example.demo.dao.PostRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.util.FieldCopyUtil;
import com.example.demo.util.Log;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;

import java.util.*;

@Service
public class PostService implements  Modifiable<Post>{

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository repository, UserRepository userRepository) {
        this.postRepository = repository;
        this.userRepository = userRepository;
    }


    @Override
    public Post getById(Long id) {
        return  postRepository.findById(id).orElseThrow(()->new IllegalStateException("Post not found"));
    }

    @Override
    public List<Post> gets() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> gets(int offset, int limit) {
        Pageable paging = PageRequest.of(offset, limit);
        Page<Post> result = postRepository.findAll(paging);
        return result.toList();
    }

    @Override
    public Post create(Post post) {
        boolean isExist = userRepository.existsById(post.getUserId());
        if (!isExist) {
            throw new IllegalStateException("User not found");
        }
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post update(Long postId,Post object) {
        Post findPost = postRepository.findById(postId).orElseThrow(() -> new IllegalStateException("Post with id" + postId + " does not exist"));
        FieldCopyUtil.merge(postId, findPost);
        Log.log(findPost.toString());
        postRepository.save(findPost);
        return findPost;
    }

    @Override
    public void delete(Long postId) {
        boolean ifExists = postRepository.existsById(postId);
        if (!ifExists) {
            throw new IllegalStateException("post not found by id: " + postId);
        }
        postRepository.deleteById(postId);
    }
}

