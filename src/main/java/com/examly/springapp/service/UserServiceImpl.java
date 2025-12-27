package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;

@Service
public class UserServiceImpl implements UserService {

  private static final List<User> users = new ArrayList<>();
  private static long idCounter = 1;

  public User addUser(User user) {
    user.setUserId(idCounter++);
    users.add(user);
    return user;
  }

  public List<User> getAllUsers() {
    return users;
  }

  public User getUserById(Long id) {
    return users.stream()
        .filter(u -> u.getUserId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public User updateUser(Long id, User updated) {
    User user = getUserById(id);
    if (user != null) {
      user.setUsername(updated.getUsername());
      user.setEmail(updated.getEmail());
      user.setRole(updated.getRole());
      user.setPhoneNumber(updated.getPhoneNumber());
    }
    return user;
  }
}

