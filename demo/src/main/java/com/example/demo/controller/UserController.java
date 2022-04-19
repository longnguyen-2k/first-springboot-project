package com.example.demo.controller;

import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.services.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;


    @GetMapping
    public List<User> getUsers(){
        return userServiceImpl.gets();
    }
    @GetMapping(path = "{userId}/posts")
    public List<Post> getPostsHasRelationship(@PathVariable("userId") Long userId){
        return userServiceImpl.getPostsHasRelationship(userId);
    }
    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return  userServiceImpl.getById(userId);
    }
    @PostMapping
    public  User createUser(@RequestBody User user){
        return  userServiceImpl.create(user);
    }

    @PutMapping(path = "{userId}")
    public  User  updateUser(@PathVariable("userId")Long userId,@RequestBody User user){
        return  userServiceImpl.update(userId, user);
    }
    @PutMapping(path = "{userId}/change-password")
    public  void  updatePassword(@PathVariable("userId")Long userId,@RequestParam String oldPassword,@RequestParam String newPassword ){
        userServiceImpl.changePassword(userId, oldPassword,newPassword);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userServiceImpl.deleteUser(userId);
    }

}