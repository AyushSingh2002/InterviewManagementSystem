package com.spring.interviewApp.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interviews")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InterviewEntity 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_time")
  private Date dateTime;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "role")
  private String role; 

  @ManyToMany
  @JoinTable(name = "result", joinColumns = @JoinColumn(name = "interview_id"), inverseJoinColumns = @JoinColumn(name = "candidate_id"))
  private List<CandidateEntity> candidates;
}
