package com.project.questapp.controllers;

import com.project.questapp.entites.User;
import com.project.questapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("getUser/{UserId}")
    public User getUser(@PathVariable Long UserId){
        return userService.getUser(UserId);
    }
    @PostMapping("createUser")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }
    @PutMapping("updateUser")
    public User updateUser(@RequestBody User newUser){
        return userService.updateUser(newUser);
    }
    @DeleteMapping("deleteUser/{UserId}")
    public void deleteUser(@PathVariable Long UserId){
        userService.deleteUser(UserId);
    }
}
