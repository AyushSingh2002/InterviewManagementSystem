package com.spring.interviewApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.interviewApp.Entities.InterviewEntity;

public interface InterviewRepo extends JpaRepository<InterviewEntity, Long> 
{
  
}
