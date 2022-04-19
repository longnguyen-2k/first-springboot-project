package com.example.demo.dao;

import com.example.demo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName,String password);
    boolean existsByEmail(String email);
    boolean existsByUserNameOrEmailOrPhone(String userName,String email,String password);
}
