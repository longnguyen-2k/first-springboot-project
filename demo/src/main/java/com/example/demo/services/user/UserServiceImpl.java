package com.example.demo.services.user;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.post.Post;
import com.example.demo.entity.user.User;
import com.example.demo.services.Modifiable;
import com.example.demo.util.FieldCopyUtil;
import com.example.demo.util.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void deleteUser(Long userId) {
        boolean isExist = userRepository.existsById(userId);
        if (!isExist) {
            throw new IllegalStateException("User with id \"+userId +\"is not exits");
        }
        userRepository.deleteById(userId);

    }


    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
    }


    public List<User> gets() {
        return userRepository.findAll();
    }


    public List<User> gets(int offset, int limit) {
        return null;
    }


    public User create(User user) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("email", ignoreCase());
//                .withMatcher("userName",ignoreCase())
//                .withMatcher("phone",ignoreCase());
        Example existsCondition= Example.of(user,matcher);
        boolean isExists= userRepository.existsByUserNameOrEmailOrPhone(user.getUserName(),user.getEmail(),user.getPassword());
        if (isExists){
            throw  new IllegalStateException("Email or userName or phone is used");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<Post> getPostsHasRelationship(Long userId) {
        return userRepository.getById(userId).getPost();
    }

    @Override
    public boolean login(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        return user != null;
    }


    @Transactional
    public User update(Long id, User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id" + id + " does not exist"));
        FieldCopyUtil.merge(id, findUser, List.of("password", "username", "email"));
        Log.log(findUser.toString());
        userRepository.save(findUser);
        return findUser;
    }


    @Transactional
    public boolean changePassword(Long id, String oldPassword, String newPassword) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with id" + id + " does not exist"));
        if (passwordEncoder.matches(oldPassword, findUser.getPassword())) {
            findUser.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(findUser);
            return true;
        }
        return false;
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}
