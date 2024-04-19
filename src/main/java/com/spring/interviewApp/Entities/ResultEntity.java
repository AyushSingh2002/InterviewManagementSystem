package com.spring.interviewApp.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "results")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(CandidateInterviewLink.class)
public class ResultEntity 
{
  @Id
  private Long candidateID;

  @Id
  private Long interviewID;

  @Column(name = "result")
  private String result;
}
