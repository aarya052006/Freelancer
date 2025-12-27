package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private static final List<Department> departments = new ArrayList<>();
  private static long idCounter = 1;

  @Override
  public Department addDepartment(Department department) {
    department.setDepartmentId(idCounter++);
    departments.add(department);
    return department;
  }

  @Override
  public List<Department> getAllDepartments() {
    return departments;
  }

  @Override
  public Department getDepartmentById(Long id) {
    for (Department d : departments) {
      if (d.getDepartmentId().equals(id)) {
        return d;
      }
    }
    return null;
  }

  @Override
  public Department updateDepartment(Long id, Department department) {
    for (Department d : departments) {
      if (d.getDepartmentId().equals(id)) {
        d.setDepartmentName(department.getDepartmentName());
        d.setContactEmail(department.getContactEmail());
        d.setContactPhone(department.getContactPhone());
        return d;
      }
    }
    return null;
  }
}

