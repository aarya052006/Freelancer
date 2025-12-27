package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  private final DepartmentServiceImpl service;

  public DepartmentController(DepartmentServiceImpl service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
    return new ResponseEntity<>(service.addDepartment(department), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Department>> getAllDepartments() {
    return ResponseEntity.ok(service.getAllDepartments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getDepartmentById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(
      @PathVariable Long id,
      @RequestBody Department department) {
    return ResponseEntity.ok(service.updateDepartment(id, department));
  }

  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<Page<Department>> getDepartmentsWithPagination(
      @PathVariable int page,
      @PathVariable int size) {

    Pageable pageable = PageRequest.of(page, size);
    Page<Department> departmentPage =
        new PageImpl<>(service.getAllDepartments(), pageable, service.getAllDepartments().size());

    return ResponseEntity.ok(departmentPage);
  }
}

