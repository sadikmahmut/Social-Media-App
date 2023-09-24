package com.project.questapp.services;

import com.project.questapp.entites.User;
import com.project.questapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long UserId){
        return userRepository.findById(UserId).orElse(null);
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(User newUser){
        Optional<User> user = userRepository.findById(newUser.getId());
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(foundUser.getUserName());
            foundUser.setPassword(foundUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else return null;
    }

    public void deleteUser(Long UserId){
        userRepository.deleteById(UserId);
    }
}
