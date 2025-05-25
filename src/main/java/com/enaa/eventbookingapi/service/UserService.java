package com.enaa.eventbookingapi.service;


import com.enaa.eventbookingapi.Model.Role;
import com.enaa.eventbookingapi.Model.User;
import com.enaa.eventbookingapi.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String password, Role role) {
        User user = new User();
        user.setName(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepository.save(user);
    }

    public User authenticate(String username, String password) {
        User user = userRepository.findByName(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}