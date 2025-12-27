package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserServiceImpl service;

  public UserController(UserServiceImpl service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getUserById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable Long id,
      @RequestBody User user) {
    return ResponseEntity.ok(service.updateUser(id, user));
  }
}

