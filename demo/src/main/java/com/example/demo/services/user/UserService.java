package com.example.demo.services.user;

import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.services.Modifiable;

import java.util.List;

public interface UserService extends Modifiable<User> {
    void deleteUser(Long userId);
    boolean changePassword(Long id, String oldPassword, String newPassword);
    List<Post> getPostsHasRelationship(Long userId);
    boolean login(String userName, String password);

}
