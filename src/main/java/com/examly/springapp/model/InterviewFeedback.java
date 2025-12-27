package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InterviewFeedback {

  @Id
  private Long feedbackId;
  private String content;
  private Boolean isInternal;
  private String interviewRound;

  public InterviewFeedback() {}

  public Long getFeedbackId() { return feedbackId; }
  public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  public Boolean getIsInternal() { return isInternal; }
  public void setIsInternal(Boolean isInternal) { this.isInternal = isInternal; }

  public String getInterviewRound() { return interviewRound; }
  public void setInterviewRound(String interviewRound) { this.interviewRound = interviewRound; }
}

