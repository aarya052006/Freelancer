package com.examly.springapp.model;
import jakarta.persistence.*;
@Entity
public class JobApplication {
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long applicationId;
  private String coverletter;
  private String resumeurl;
  private String status;
  private String priority;
  private int userId;
  private int jobPositionId;
  public Long getApplicationId(){
  return applicationId;
  }
  public void setApplicationId(Long applicationId){
  this.applicationId=applicationId;
  }
  public String getCoverletter(){
  return coverletter;
  }
  public void setCoverletter(String coverletter){
  this.coverletter=coverletter;
  }
  public String getResumeurl(){
  return resumeurl;
  }
  public void setResumeurl(String resumeurl){
  this.resumeurl=resumeurl;
  }
  public String getStatus(){
  return status;
  }
  public void setStatus(String status){
  this.status=status;
  }
  public String getPriority(){
  return priority;
}

public void setPriority(String priority){
  this.priority = priority;
}
public int getUserId(){
  return userId;
}

public void setUserId(int userId){
  this.userId = userId;
}

public int getJobPositionId(){
  return jobPositionId;
}

public void setJobPositionId(int jobPositionId){
  this.jobPositionId = jobPositionId;
}
}



  
