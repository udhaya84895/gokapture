package com.example.gokapture.service;

import com.example.gokapture.model.User;
import com.example.gokapture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);

        user.setPassword((password));
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }
        User user = userOptional.get();
        if(!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    public User updateUser(Long userId, User user) {

        Optional<User> user1 = userRepository.findById(userId);
        if (user1.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
