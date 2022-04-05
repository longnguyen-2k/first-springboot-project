package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return  userRepository.findAll();
    }

    public User createUser(User user){

        return  userRepository.save(user);
    }

    public  User getOneUser(Long userId){
        return  userRepository.getById(userId);
    }
    @Transactional
    public  void updateUser(Long userId,String password){
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("User with id "+userId +"is not exits"));

        if (!password.isBlank()&&password.isBlank()&& Objects.equals(password,user.getPassword())){
            user.setPassword(password);
        }
    }

    public void deleteUser(Long userId){
        boolean isExist = userRepository.existsById(userId);
        if (!isExist){
            throw  new IllegalStateException("User with id \"+userId +\"is not exits");
        }
        userRepository.deleteById(userId);

    }

}
