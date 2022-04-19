package com.example.demo.controller;

import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.security.SecurityConstants;
import com.example.demo.services.user.UserServiceImpl;
import com.example.demo.util.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final String PREFIX_PATH = "api/users";

    @GetMapping(path = PREFIX_PATH)
    public List<User> getUsers(){
        return userServiceImpl.gets();
    }
    @GetMapping(path = PREFIX_PATH+"/{userId}/posts")
    public List<Post> getPostsHasRelationship(@PathVariable("userId") Long userId){
        return userServiceImpl.getPostsHasRelationship(userId);
    }
    @GetMapping(path = PREFIX_PATH+"/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return  userServiceImpl.getById(userId);
    }

    @PostMapping(path = SecurityConstants.SIGN_UP_URL)
    public  User createUser(@RequestBody User user){
        return  userServiceImpl.create(user);
    }

    @PutMapping(path = PREFIX_PATH+ "/{userId}")
    public  User  updateUser(@PathVariable("userId")Long userId,@RequestBody User user){
        return  userServiceImpl.update(userId, user);
    }
    @PutMapping(path = PREFIX_PATH+"/{userId}/change-password")
    public  void  updatePassword(@PathVariable("userId")Long userId,@RequestParam String oldPassword,@RequestParam String newPassword ){
        userServiceImpl.changePassword(userId, oldPassword,newPassword);
    }
    @DeleteMapping(path =PREFIX_PATH+ "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userServiceImpl.deleteUser(userId);
    }

}