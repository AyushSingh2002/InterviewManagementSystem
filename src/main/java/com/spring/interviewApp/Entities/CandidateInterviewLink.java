package com.spring.interviewApp.Entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateInterviewLink implements Serializable
{
  private static final long serialVersionUID = 1L;

  private Long candidateID;
  private Long interviewID;
}
