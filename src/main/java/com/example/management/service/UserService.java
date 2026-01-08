package com.example.management.service;

import com.example.management.entity.User;
import com.example.management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find user by this id"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User candidate = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find user by this id"));;
        candidate.setName(user.getName());
        candidate.setEmail(user.getEmail());
        candidate.setSalary(user.getSalary());
        return userRepository.save(candidate);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
