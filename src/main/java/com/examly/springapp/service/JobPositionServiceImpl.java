package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobPosition;

@Service
public class JobPositionServiceImpl implements JobPositionService {

  private static final List<JobPosition> positions = new ArrayList<>();
  private static long idCounter = 1;

  public JobPosition addJobPosition(JobPosition jobPosition) {
    jobPosition.setPositionId(idCounter++);
    positions.add(jobPosition);
    return jobPosition;
  }

  public List<JobPosition> getAllJobPositions() {
    return positions;
  }

  public JobPosition getJobPositionById(Long id) {
    return positions.stream()
        .filter(p -> p.getPositionId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public JobPosition updateJobPosition(Long id, JobPosition updated) {
    JobPosition p = getJobPositionById(id);
    if (p != null) {
      p.setPositionTitle(updated.getPositionTitle());
      p.setDescription(updated.getDescription());
      p.setLocation(updated.getLocation());
      p.setExperienceRequired(updated.getExperienceRequired());
      p.setOpenings(updated.getOpenings());
    }
    return p;
  }
}

