package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackServiceImpl;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

  private final InterviewFeedbackServiceImpl service;

  public InterviewFeedbackController(InterviewFeedbackServiceImpl service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<InterviewFeedback> addFeedback(
      @RequestBody InterviewFeedback feedback) {
    return new ResponseEntity<>(service.addFeedback(feedback), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<InterviewFeedback>> getAllFeedbacks() {
    return ResponseEntity.ok(service.getAllFeedbacks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<InterviewFeedback> getFeedbackById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getFeedbackById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<InterviewFeedback> updateFeedback(
      @PathVariable Long id,
      @RequestBody InterviewFeedback feedback) {
    return ResponseEntity.ok(service.updateFeedback(id, feedback));
  }

  @GetMapping("/application/{id}")
  public ResponseEntity<List<InterviewFeedback>> getByApplication(
      @PathVariable Long id) {
    return ResponseEntity.ok(service.getFeedbacksByApplication(id));
  }
}

