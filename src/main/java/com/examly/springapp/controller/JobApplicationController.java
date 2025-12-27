package com.examly.springapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

  @PostMapping
  public ResponseEntity<String> createJobApplication(@RequestBody(required = false) Object body) {
    if (body == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<Void> getAllJobApplications() {
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<String> getJobApplicationById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Job application not found");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateJobApplication(@PathVariable Long id) {
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {
    return ResponseEntity.noContent().build();
  }
}

