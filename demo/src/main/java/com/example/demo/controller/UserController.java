package com.example.demo.controller;

import com.example.demo.entity.user.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")

public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.gets();
    }
    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return  userService.getById(userId);
    }
    @PostMapping
    public  User createUser(@RequestBody User user){
        return  userService.create(user);
    }

    @PutMapping(path = "{userId}")
    public  User  updateUser(@PathVariable("userId")Long userId,@RequestBody User user){
        return  userService.update(userId, user);
    }
    @PutMapping(path = "{userId}/change-password")
    public  void  updatePassword(@PathVariable("userId")Long userId,@RequestParam String oldPassword,@RequestParam String newPassword ){
        userService.changePassword(userId, oldPassword,newPassword);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}