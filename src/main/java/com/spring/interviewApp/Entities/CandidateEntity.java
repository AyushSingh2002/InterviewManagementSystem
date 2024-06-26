package com.spring.interviewApp.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateEntity 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "candidate_name")
  private String name;

  @Column(name = "contact")
  private String contact;

  @Column(name = "resume")
  @Lob
  private String resume;

  @ManyToMany(mappedBy = "candidates")
  @JsonIgnore
  private List<InterviewEntity> interviews;
}
