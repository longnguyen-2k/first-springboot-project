package com.example.demo.controller;

import com.example.demo.models.user.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userService.getUsers();
    }
    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return  userService.getOneUser(userId);
    }
    @PostMapping
    public  User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }

    @PutMapping(path = "{userId}")
    public  void  updateUser(@PathVariable("userId")Long userId,@RequestParam(required = false) String password ){
        userService.updateUser(userId, password);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}