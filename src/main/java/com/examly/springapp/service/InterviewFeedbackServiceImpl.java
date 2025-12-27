package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.InterviewFeedback;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

  private static final List<InterviewFeedback> feedbacks = new ArrayList<>();
  private static long idCounter = 1;

  public InterviewFeedback addFeedback(InterviewFeedback feedback) {
    feedback.setFeedbackId(idCounter++);
    feedbacks.add(feedback);
    return feedback;
  }

  public List<InterviewFeedback> getAllFeedbacks() {
    return feedbacks;
  }

  public InterviewFeedback getFeedbackById(Long id) {
    return feedbacks.stream()
        .filter(f -> f.getFeedbackId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public InterviewFeedback updateFeedback(Long id, InterviewFeedback updated) {
    InterviewFeedback f = getFeedbackById(id);
    if (f != null) {
      f.setContent(updated.getContent());
      f.setIsInternal(updated.getIsInternal());
      f.setInterviewRound(updated.getInterviewRound());
    }
    return f;
  }

  public List<InterviewFeedback> getFeedbacksByApplication(Long appId) {
    return feedbacks;
  }
}

