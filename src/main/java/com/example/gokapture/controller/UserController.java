package com.example.gokapture.controller;


import com.example.gokapture.dto.LoginRequestDto;
import com.example.gokapture.dto.SignupRequestDto;
import com.example.gokapture.model.User;
import com.example.gokapture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequestDto requestDto){
        User user = userService.signUp(requestDto.getEmail(),
                requestDto.getPassword(), requestDto.getName());
        return ResponseEntity.ok("Account created successfully for " + user.getName());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto){
         User user =userService.login(requestDto.getEmail(),
                requestDto.getPassword());

         return ResponseEntity.ok("Login successfully for " + user.getName());
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, User user){
        User user1 = userService.updateUser(userId, user);
        return ResponseEntity.ok("User updated successfully for " + user1.getName());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully for " + userId);
    }
}
