package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.util.FieldCopyUtil;
import com.example.demo.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService implements Modifiable<User> {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long userId){
        boolean isExist = userRepository.existsById(userId);
        if (!isExist){
            throw  new IllegalStateException("User with id \"+userId +\"is not exits");
        }
        userRepository.deleteById(userId);

    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new IllegalStateException("User not found"));
    }

    @Override
    public List<User> gets() {
        return  userRepository.findAll();
    }

    @Override
    public List<User> gets(int offset, int limit) {
        return null;
    }

    @Override
    public User create(User user) {
        return  userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(Long id, User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id" + id + " does not exist"));
        FieldCopyUtil.merge(id, findUser,List.of("password","username","email"));
        Log.log(findUser.toString());
        userRepository.save(findUser);
        return findUser;
    }
    @Transactional
    public boolean changePassword(Long id,String oldPassword,String newPassword){
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id" + id + " does not exist"));
        if (findUser.getPassword().equals(oldPassword)){
            findUser.setPassword(newPassword);
            userRepository.save(findUser);
            return true;
        }
        return  false;


    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
